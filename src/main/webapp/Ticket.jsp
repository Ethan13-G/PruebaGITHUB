<%-- 
    Document   : Ticket
    Created on : 22 may 2026, 11:35:35 p. m.
    Author     : Carlos Alberto
--%>

<%@ page import="MODELO.Libro, java.time.LocalDate" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket</title>
</head>
<body>

<h2>Ticket de Préstamo</h2>

<%
Libro libro = (Libro) request.getAttribute("libro");
LocalDate fecha = (LocalDate) request.getAttribute("fecha");
%>

<p>Fecha: <%= fecha %></p>
<p>Libro: <%= libro.getNombre() %></p>
<p>Autor: <%= libro.getAutor() %></p>

<hr>

<a href="PrestamoServlet?accion=listar">Volver</a>

</body>
</html>