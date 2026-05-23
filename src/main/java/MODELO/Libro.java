/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author agomz
 */
public class Libro {

    private int idLibro;
    private String codigo;
    private String nombre;
    private String autor;
    private String genero;
    private int disponibilidad;

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(int idLibro, String codigo, String nombre,
                 String autor, String genero, int disponibilidad) {

        this.idLibro = idLibro;
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
    }

    // Getters y Setters

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {

        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {

        if(autor == null || autor.trim().isEmpty()){
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }

        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {

        if(genero == null || genero.trim().isEmpty()){
            throw new IllegalArgumentException("El género no puede estar vacío");
        }

        this.genero = genero;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {

        if(disponibilidad < 0){
            throw new IllegalArgumentException("La disponibilidad no puede ser negativa");
        }

        this.disponibilidad = disponibilidad;
    }

    // Método para verificar disponibilidad
    public boolean disponible() {
        return disponibilidad > 0;
    }

    // Reducir stock
    public void prestarLibro() {

        if(disponibilidad > 0){
            disponibilidad--;
        } else {
            System.out.println("No hay libros disponibles");
        }
    }

    // Aumentar stock
    public void devolverLibro() {
        disponibilidad++;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
