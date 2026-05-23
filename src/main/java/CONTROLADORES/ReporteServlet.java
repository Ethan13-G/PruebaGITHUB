/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

/**
 *
 * @author agomz
 */
import MODELO.Prestamo;

import java.io.IOException;
import java.time.LocalDate;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ReporteServlet", urlPatterns = {"/ReporteServlet"})
public class ReporteServlet extends HttpServlet {

    PrestamoDAO dao = new PrestamoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        generarReporte(request, response);
    }

    private void generarReporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Prestamo> lista = dao.listar();

        int totalPrestamos = 0;

        double totalMora = 0;

        LocalDate hoy = LocalDate.now();

        for (Prestamo p : lista) {

            if (p.getFechaPrestamo().equals(hoy)) {

                totalPrestamos++;

                totalMora += p.getMora();
            }
        }

        request.setAttribute(
                "totalPrestamos",
                totalPrestamos
        );

        request.setAttribute(
                "totalMora",
                totalMora
        );

        request.setAttribute(
                "listaPrestamos",
                lista
        );

        request.getRequestDispatcher("reportes.jsp")
                .forward(request, response);
    }

    private static class PrestamoDAO {

        public PrestamoDAO() {
        }

        private List<Prestamo> listar() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}