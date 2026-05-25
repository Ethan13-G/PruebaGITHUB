/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static final String URL =
            "jdbc:sqlserver://192.168.0.8;"
            + "databaseName=BibliotecaPOO;"
            + "encrypt=false;";

    private static final String USER = "UsuarioLibreria";
    private static final String PASSWORD = "Contra123";

    public Connection conectar() {

        Connection conn = null;

        try {

            System.out.println("Cargando driver...");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("Driver cargado");

            System.out.println("Intentando conexión...");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("CONEXION EXITOSA");

        } catch (Exception e) {

            System.out.println("ERROR REAL:");

            e.printStackTrace();
        }

        return conn;
    }
}