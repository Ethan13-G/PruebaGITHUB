/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author agomz
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private int idPrestamo;
    private int idLibro;
    private String nombreUsuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private double mora;

    // Constructor vacío
    public Prestamo() {
    }

    // Constructor con parámetros
    public Prestamo(int idPrestamo, int idLibro,
                     String nombreUsuario,
                     LocalDate fechaPrestamo,
                     LocalDate fechaDevolucion,
                     double mora) {

        this.idPrestamo = idPrestamo;
        this.idLibro = idLibro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.mora = mora;
    }

    // Getters y Setters

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {

        if(idLibro <= 0){
            throw new IllegalArgumentException("ID libro inválido");
        }

        this.idLibro = idLibro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {

        if(nombreUsuario == null || nombreUsuario.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre usuario obligatorio");
        }

        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {

        if(mora < 0){
            throw new IllegalArgumentException("La mora no puede ser negativa");
        }

        this.mora = mora;
    }

    // Calcular días de préstamo
    public long calcularDiasPrestamo() {

        return ChronoUnit.DAYS.between(
                fechaPrestamo,
                fechaDevolucion
        );
    }

    // Calcular mora
    public double calcularMora(LocalDate fechaEntregaReal) {

        long diasRetraso = ChronoUnit.DAYS.between(
                fechaDevolucion,
                fechaEntregaReal
        );

        if(diasRetraso > 0){

            mora = diasRetraso * 0.50;

        } else {

            mora = 0;
        }

        return mora;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", idLibro=" + idLibro +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", mora=" + mora +
                '}';
    }
}

