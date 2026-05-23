<%-- 
    Document   : Prestamos
    Created on : 22 may 2026, 11:33:31 p. m.
    Author     : Carlos Alberto
--%>

<%@page import="MODELO.Prestamo"%>
<%@ page import="java.util.*, MODELO.Prestamo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Préstamos</title>
</head>
<body>

<h2>Registrar Préstamo</h2>

<form action="PrestamoServlet" method="post">
    <input type="hidden" name="accion" value="guardar">
    ID Libro: <input type="number" name="idLibro"><br>
    Usuario: <input type="text" name="usuario"><br>
    <input type="submit" value="Prestar">
</form>

<hr>

<h3>Lista de Préstamos</h3>

<table border="1">
<tr>
    <th>ID</th>
    <th>Libro</th>
    <th>Usuario</th>
    <th>Fecha</th>
    <th>Devolución</th>
</tr>

<%
List<Prestamo> lista = (List<Prestamo>) request.getAttribute("listaPrestamos");
if (lista != null) {
    for (Prestamo p : lista) {
%>
<tr>
    <td><%= p.getIdPrestamo() %></td>
    <td><%= p.getIdLibro() %></td>
    <td><%= p.getNombreUsuario() %></td>
    <td><%= p.getFechaPrestamo() %></td>
    <td><%= p.getFechaDevolucion() %></td>
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

