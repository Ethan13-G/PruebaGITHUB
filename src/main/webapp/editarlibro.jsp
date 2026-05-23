<%-- 
    Document   : editarlibro
    Created on : 22 may 2026, 11:22:59 p. m.
    Author     : Carlos Alberto
--%>

<%@page import="MODELO.Libro"%>
<%@ page import="MODELO.Libro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Libro</title>
</head>
<body>

<h2>Editar Libro</h2>

<%
Libro l = (Libro) request.getAttribute("libro");
%>

<form action="LibroServlet" method="post">
    <input type="hidden" name="accion" value="actualizar">
    <input type="hidden" name="idLibro" value="<%= l.getIdLibro() %>">

    Código: <input type="text" name="codigo" value="<%= l.getCodigo() %>"><br>
    Nombre: <input type="text" name="nombre" value="<%= l.getNombre() %>"><br>
    Autor: <input type="text" name="autor" value="<%= l.getAutor() %>"><br>
    Género: <input type="text" name="genero" value="<%= l.getGenero() %>"><br>
    Disponibilidad: <input type="number" name="disponibilidad" value="<%= l.getDisponibilidad() %>"><br>

    <input type="submit" value="Actualizar">
</form>

</body>
</html>