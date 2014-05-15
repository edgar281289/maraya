<%-- 
    Document   : MostrarPacientes
    Created on : 21-abr-2014, 13:45:20
    Author     : Daniel Guerrero Salas
--%>

<%@page import="maraya.entity.Historial"%>
<%@page import="maraya.entity.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes</title>
    </head>
    <body>
        <%
           List<Paciente> lsPacientes = (List<Paciente>) request.getAttribute("listaPacientes");
           Historial historial;
        %>
        <table border="10">
            <caption> Pacientes</caption>
		<tr>
                        <th>DNI</th>
                        <th>Nombre</th>
			<th>Apellidos</th>
                        <th>Historial</th>
                        <th>Fecha del Historial</th>
		</tr>
                <%
                    for(Paciente p : lsPacientes){
                       historial = p.getHistorial();
                %>
                <tr>
                        <td><%= p.getDni() %></td>
                        <td><%= p.getNombre() %> </td>
			<td><%= p.getApellidos() %> </td>
                        <td><%= historial.getInformacion() %></td>
                        <td><%= historial.getFechaCreacion() %></td>
                        <td><a href= "RegistrosPaciente?historial=<%= historial.getId() %>"> Leer Registros del paciente </a></td>
                </tr>
                <% } %>
        </table>
        <a href='index.jsp'> Volver </a>
    </body>
</html>
