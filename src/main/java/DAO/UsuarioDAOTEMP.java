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
import MODELO.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAOTEMP {

    private final ConexionDB conexion = new ConexionDB();

    // REGISTRAR USUARIO
    public boolean agregarUsuario(Usuario usuario) {

        String sql = "INSERT INTO Usuarios(nombre, apellido, correo, telefono, usuario, password) "
                + "VALUES(?,?,?,?,?,?)";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido()); // Revisa que en Usuario sea getApellido()
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getUsuario());  // Revisa que en Usuario sea getUsuario()
            ps.setString(6, usuario.getPassword()); // Revisa que en Usuario sea getPassword()

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error agregarUsuario: " + e.getMessage());
            return false;
        }
    }

    // LISTAR USUARIOS
    public ArrayList<Usuario> listarUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido")); // Revisa tu setApellido
                usuario.setCorreo(rs.getString("correo"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setUsuario(rs.getString("usuario"));   // Revisa tu setUsuario
                usuario.setPassword(rs.getString("password")); // Revisa tu setPassword

                lista.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Error listarUsuarios: " + e.getMessage());
        }

        return lista;
    }

    // BUSCAR USUARIO
    public Usuario buscarUsuario(String username) {

        Usuario usuario = null; // Cambiado a null por defecto si no se encuentra
        String sql = "SELECT * FROM Usuarios WHERE usuario = ?";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setPassword(rs.getString("password"));
                }
            }

        } catch (Exception e) {
            System.out.println("Error buscarUsuario: " + e.getMessage());
        }

        return usuario;
    }

    // VALIDAR LOGIN
    public boolean validarLogin(String username, String password) {

        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND password = ?";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error validarLogin: " + e.getMessage());
        }

        return false;
    }

    // ELIMINAR USUARIO
    public boolean eliminarUsuario(int idUsuario) {

        String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";

        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error eliminarUsuario: " + e.getMessage());
            return false;
        }
    }
}