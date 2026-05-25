/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author agomz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=BibliotecaPOO;" 
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    private static final String USER = "Prueba2"; 
    private static final String PASSWORD = "123456789";

    // Método principal que llama tu lógica DAO
    public Connection conectar() {
        Connection conn = null;
        try {
            // Cargar el driver oficial JDBC de Microsoft SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Crear la conexión pasando la URL, el usuario Prueba2 y su contraseña
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a SQL Server (BibliotecaPOO) usando el usuario Prueba2!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: El driver JDBC de SQL Server no se encuentra en las librerías del proyecto.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con SQL Server. Verifica que la contraseña de 'Prueba2' sea correcta o que el puerto 1433 esté habilitado.");
            e.printStackTrace();
        }
        return conn;
    }
    
    // Mantiene la compatibilidad total con tus métodos DAO existentes
    public Connection getConnection() {
        return conectar();
    }
}