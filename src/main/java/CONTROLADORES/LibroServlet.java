/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

/**
 *
 * @author agomz
 */
import DAO.LibroDAOTEMP;
import MODELO.Libro;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet"})
public class LibroServlet extends HttpServlet {

    LibroDAOTEMP dao = new LibroDAOTEMP();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listarLibros(request, response);
                break;

            case "editar":
                obtenerLibro(request, response);
                break;

            case "eliminar":
                eliminarLibro(request, response);
                break;

            case "buscar":
                buscarLibro(request, response);
                break;

            default:
                listarLibros(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {

            case "guardar":
                guardarLibro(request, response);
                break;

            case "actualizar":
                actualizarLibro(request, response);
                break;
        }
    }

    private void listarLibros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Libro> lista = dao.listar();

        request.setAttribute("listaLibros", lista);

        request.getRequestDispatcher("Libros.jsp")
                .forward(request, response);
    }

    private void guardarLibro(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String autor = request.getParameter("autor");
        String genero = request.getParameter("genero");

        int disponibilidad = Integer.parseInt(
                request.getParameter("disponibilidad")
        );

        if (disponibilidad < 0) {
            response.sendRedirect("Libros.jsp?error=Disponibilidad invalida");
            return;
        }

        Libro libro = new Libro();

        libro.setCodigo(codigo);
        libro.setNombre(nombre);
        libro.setAutor(autor);
        libro.setGenero(genero);
        libro.setDisponibilidad(disponibilidad);

        dao.agregar(libro);

        response.sendRedirect("LibroServlet?accion=listar");
    }

    private void obtenerLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Libro libro = dao.obtenerPorId(id);

        request.setAttribute("libro", libro);

        request.getRequestDispatcher("editarLibro.jsp")
                .forward(request, response);
    }

    private void actualizarLibro(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Libro libro = new Libro();

        libro.setIdLibro(
                Integer.parseInt(request.getParameter("idLibro"))
        );

        libro.setCodigo(request.getParameter("codigo"));
        libro.setNombre(request.getParameter("nombre"));
        libro.setAutor(request.getParameter("autor"));
        libro.setGenero(request.getParameter("genero"));

        libro.setDisponibilidad(
                Integer.parseInt(request.getParameter("disponibilidad"))
        );

        dao.actualizar(libro);

        response.sendRedirect("LibroServlet?accion=listar");
    }

    private void eliminarLibro(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        dao.eliminar(id);

        response.sendRedirect("LibroServlet?accion=listar");
    }

    private void buscarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String texto = request.getParameter("texto");

        List<Libro> lista = dao.buscar(texto);

        request.setAttribute("listaLibros", lista);

        request.getRequestDispatcher("Libros.jsp")
                .forward(request, response);
    }
}

