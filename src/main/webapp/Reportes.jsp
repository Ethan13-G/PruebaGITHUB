<%-- 
    Document   : Reportes
    Created on : 22 may 2026, 11:34:37 p. m.
    Author     : Carlos Alberto
--%>

<%@page import="MODELO.Prestamo"%>
<%@ page import="java.util.*, MODELO.Prestamo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Reportes</title>
</head>
<body>

<h2>Reporte del Día</h2>

<p>Total préstamos: <%= request.getAttribute("totalPrestamos") %></p>
<p>Total mora: $<%= request.getAttribute("totalMora") %></p>

<hr>

<table border="1">
<tr>
    <th>ID</th>
    <th>Libro</th>
    <th>Usuario</th>
    <th>Fecha</th>
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