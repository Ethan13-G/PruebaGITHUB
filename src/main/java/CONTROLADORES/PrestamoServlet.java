/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

/**
 *
 * @author agomz
 */
import DAO.LibroDAO;

import MODELO.Libro;
import MODELO.Prestamo;

import java.io.IOException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PrestamoServlet", urlPatterns = {"/PrestamoServlet"})
public class PrestamoServlet extends HttpServlet {

    PrestamoDAO prestamoDAO = new PrestamoDAO();
    LibroDAO libroDAO = new LibroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listarPrestamos(request, response);
                break;

            case "ticket":
                generarTicket(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            guardarPrestamo(request, response);
        }
    }

    private void guardarPrestamo(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int idLibro = Integer.parseInt(
                request.getParameter("idLibro")
        );

        String usuario = request.getParameter("usuario");

        Libro libro = libroDAO.obtenerPorId(idLibro);

        if (libro.getDisponibilidad() <= 0) {

            response.sendRedirect(
                    "Prestamos.jsp?error=Libro no disponible"
            );

            return;
        }

        LocalDate fechaPrestamo = LocalDate.now();

        LocalDate fechaDevolucion = fechaPrestamo.plusDays(7);

        Prestamo prestamo = new Prestamo();

        prestamo.setIdLibro(idLibro);
        prestamo.setNombreUsuario(usuario);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setMora(0);

        prestamoDAO.agregar(prestamo);

        libro.setDisponibilidad(
                libro.getDisponibilidad() - 1
        );

        libroDAO.actualizar(libro);

        response.sendRedirect(
                "PrestamoServlet?accion=ticket&idLibro=" + idLibro
        );
    }

    private void listarPrestamos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "listaPrestamos",
                prestamoDAO.listar()
        );

        request.getRequestDispatcher("Prestamos.jsp")
                .forward(request, response);
    }

    private void generarTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idLibro = Integer.parseInt(
                request.getParameter("idLibro")
        );

        Libro libro = libroDAO.obtenerPorId(idLibro);

        request.setAttribute("libro", libro);

        request.setAttribute(
                "fecha",
                LocalDate.now()
        );

        request.getRequestDispatcher("Ticket.jsp")
                .forward(request, response);
    }

    public double calcularMora(LocalDate fechaDevolucion) {

        LocalDate fechaActual = LocalDate.now();

        if (fechaActual.isAfter(fechaDevolucion)) {

            long dias = ChronoUnit.DAYS.between(
                    fechaDevolucion,
                    fechaActual
            );

            return dias * 0.50;
        }

        return 0;
    }

    private static class PrestamoDAO {

        public PrestamoDAO() {
        }

        private void agregar(Prestamo Prestamo) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object listar() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}