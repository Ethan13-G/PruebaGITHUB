<%-- 
    Document   : index
    Created on : 22 may 2026, 11:30:30 p. m.
    Author     : Carlos Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.Connection"%>
<%@page import="MODELO.ConexionDB"%>

<!DOCTYPE html>
<html>
<head>
    <title>Biblioteca</title>
</head>
<body>

<%
    ConexionDB conexion = new ConexionDB();
    Connection cn = conexion.conectar();

    if(cn != null){
        out.println("<h2>Conexión exitosa con SQL Server</h2>");
    }else{
        out.println("<h2>Error de conexión</h2>");
    }
%>
<h1>Sistema de Biblioteca</h1>

<ul>
    <li><a href="LibroServlet?accion=listar">Gestión de Libros</a></li>
    <li><a href="PrestamoServlet?accion=listar">Préstamos</a></li>
    <li><a href="ReporteServlet">Reportes</a></li>
</ul>

</body>
</html>