/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Daniel Cañas
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MODELO.ConexionDB;
import MODELO.Libro;
import java.sql.SQLException;
import java.util.List;

public class LibroDAO {

    ConexionDB conexion = new ConexionDB();
    Connection cn;

    PreparedStatement ps;
    ResultSet rs;

    // INSERTAR LIBRO
    public boolean agregarLibro(Libro libro) {

        String sql = "INSERT INTO Libros(codigo, nombre, autor, genero, disponibilidad) "
                + "VALUES(?,?,?,?,?)";

        try {

            cn = conexion.conectar();

            ps = cn.prepareStatement(sql);

            ps.setString(1, libro.getCodigo());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getGenero());
            ps.setInt(5, libro.getDisponibilidad());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error agregarLibro: " + e.getMessage());

            return false;
        }
    }

    // LISTAR LIBROS
    public ArrayList<Libro> listarLibros() {

        ArrayList<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM Libros";

        try {

            cn = conexion.conectar();

            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro();

                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setCodigo(rs.getString("codigo"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setDisponibilidad(rs.getInt("disponibilidad"));

                lista.add(libro);
            }

        } catch (SQLException e) {

            System.out.println("Error listarLibros: " + e.getMessage());
        }

        return lista;
    }

    // BUSCAR LIBRO POR CODIGO
    public Libro buscarLibro(String codigo) {

        Libro libro = new Libro();

        String sql = "SELECT * FROM Libros WHERE codigo = ?";

        try {

            cn = conexion.conectar();

            ps = cn.prepareStatement(sql);

            ps.setString(1, codigo);

            rs = ps.executeQuery();

            if (rs.next()) {

                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setCodigo(rs.getString("codigo"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setDisponibilidad(rs.getInt("disponibilidad"));
            }

        } catch (SQLException e) {

            System.out.println("Error buscarLibro: " + e.getMessage());
        }

        return libro;
    }

    // ACTUALIZAR LIBRO
    public boolean actualizarLibro(Libro libro) {

        String sql = "UPDATE Libros "
                + "SET nombre=?, autor=?, genero=?, disponibilidad=? "
                + "WHERE codigo=?";

        try {

            cn = conexion.conectar();

            ps = cn.prepareStatement(sql);

            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setInt(4, libro.getDisponibilidad());
            ps.setString(5, libro.getCodigo());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error actualizarLibro: " + e.getMessage());

            return false;
        }
    }

    // ELIMINAR LIBRO
    public boolean eliminarLibro(String codigo) {

        String sql = "DELETE FROM Libros WHERE codigo=?";

        try {

            cn = conexion.conectar();

            ps = cn.prepareStatement(sql);

            ps.setString(1, codigo);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error eliminarLibro: " + e.getMessage());

            return false;
        }
    }

    public void actualizar(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Libro obtenerPorId(int idLibro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Libro> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregar(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Libro> buscar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}