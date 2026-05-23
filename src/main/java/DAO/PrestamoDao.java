/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Daniel Cañas
 */



import MODELO.ConexionDB;
import MODELO.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    private final ConexionDB conexion = new ConexionDB();

    // REGISTRAR PRESTAMO
    public boolean registrarPrestamo(Prestamo prestamo) {

        String sql = "INSERT INTO Prestamos(idLibro, nombreUsuario, fechaPrestamo, fechaDevolucion, mora) "
                + "VALUES(?,?,?,?,?)";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getIdLibro());
            ps.setString(2, prestamo.getNombreUsuario());

            // Solución al error de fechas: Conversión de LocalDate a java.sql.Date
            ps.setDate(3, java.sql.Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(4, java.sql.Date.valueOf(prestamo.getFechaDevolucion()));

            ps.setDouble(5, prestamo.getMora());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error registrarPrestamo: " + e.getMessage());
            return false;
        }
    }

    // LISTAR PRESTAMOS
    public ArrayList<Prestamo> listarPrestamos() {

        ArrayList<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();

                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setIdLibro(rs.getInt("idLibro"));
                prestamo.setNombreUsuario(rs.getString("nombreUsuario"));
                
                prestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
                prestamo.setFechaDevolucion(rs.getDate("fechaDevolucion").toLocalDate());
                
                prestamo.setMora(rs.getDouble("mora"));

                lista.add(prestamo);
            }

        } catch (Exception e) {
            System.out.println("Error listarPrestamos: " + e.getMessage());
        }

        return lista;
    }

    // CALCULAR TOTAL PRESTAMOS
    public int totalPrestamos() {

        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM Prestamos";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (Exception e) {
            System.out.println("Error totalPrestamos: " + e.getMessage());
        }

        return total;
    }

    public List<Prestamo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregar(Prestamo prestamo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}