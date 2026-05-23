/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author agomz
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String usuario; 
    private String password;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int idUsuario, String nombre, String apellido, String correo, String telefono, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }

    // Getters y Setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        this.nombre = nombre;
    }

    public String getApellido() { // Añadido
        return apellido;
    }

    public void setApellido(String apellido) { // Añadido
        if(apellido == null || apellido.trim().isEmpty()){
            throw new IllegalArgumentException("Apellido obligatorio");
        }
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo == null || !correo.contains("@")){
            throw new IllegalArgumentException("Correo inválido");
        }
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono == null || telefono.length() < 8){
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public String getUsuario() { // Añadido
        return usuario;
    }

    public void setUsuario(String usuario) { // Añadido
        if(usuario == null || usuario.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }
        this.usuario = usuario;
    }

    public String getPassword() { // Añadido
        return password;
    }

    public void setPassword(String password) { // Añadido
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}