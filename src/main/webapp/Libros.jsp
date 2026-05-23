<%-- 
    Document   : Libros
    Created on : 22 may 2026, 11:31:24 p. m.
    Author     : Carlos Alberto
--%>

<%@page import="MODELO.Libro"%>
<%@ page import="java.util.*, MODELO.Libro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Libros</title>
</head>
<body>

<h2>Gestión de Libros</h2>

<form action="LibroServlet" method="post">
    <input type="hidden" name="accion" value="guardar">
    Código: <input type="text" name="codigo"><br>
    Nombre: <input type="text" name="nombre"><br>
    Autor: <input type="text" name="autor"><br>
    Género: <input type="text" name="genero"><br>
    Disponibilidad: <input type="number" name="disponibilidad"><br>
    <input type="submit" value="Guardar">
</form>

<hr>

<form action="LibroServlet" method="get">
    <input type="hidden" name="accion" value="buscar">
    Buscar: <input type="text" name="texto">
    <input type="submit" value="Buscar">
</form>

<hr>

<table border="1">
<tr>
    <th>ID</th>
    <th>Código</th>
    <th>Nombre</th>
    <th>Autor</th>
    <th>Disponibilidad</th>
    <th>Acciones</th>
</tr>

<%
List<Libro> lista = (List<Libro>) request.getAttribute("listaLibros");
if (lista != null) {
    for (Libro l : lista) {
%>
<tr>
    <td><%= l.getIdLibro() %></td>
    <td><%= l.getCodigo() %></td>
    <td><%= l.getNombre() %></td>
    <td><%= l.getAutor() %></td>
    <td><%= l.getDisponibilidad() %></td>
    <td>
        <a href="LibroServlet?accion=editar&id=<%= l.getIdLibro() %>">Editar</a>
        <a href="LibroServlet?accion=eliminar&id=<%= l.getIdLibro() %>">Eliminar</a>
    </td>
</tr>
<%
    }
}
%>

</table>

<br>
<a href="index.jsp">Volver</a>

</body>
</html>