<%-- 
    Document   : ConsultarHistorial
    Created on : 20-abr-2014, 19:53:42
    Author     : Pulgy
--%>
<%@page import="maraya.entity.Medicos"%>
<%@page import="maraya.entity.RegistroHistorial"%>
<%@page import="java.util.List"%>
<%@page import="maraya.entity.Historial" %>
<%@page import="maraya.entity.Paciente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Consulta de Historial Clinico</title>
    </head>
    <body>
        <%
            List <RegistroHistorial> listRegistroHistorial = (List<RegistroHistorial>) request.getAttribute("ListaRegistrosHistorial");
            Historial historial = (Historial) request.getAttribute("Historial");
            Paciente paciente = (Paciente) request.getAttribute("Paciente");
        %>
        <h1>Historial Clinico De <%= paciente.getNombre() +" " + paciente.getApellidos() %></h1>
       
        
        <p>
            DNI: <%= paciente.getDni()%> <br/>
            
            Fecha Nacimiento: <%= paciente.getFechaNacimiento() %> <br/>
      
            NºHistorial: <%= historial.getNHistorial() %><br/>
        
            Fecha de Creaci&oacute;n del Historial: <%= historial.getFechaCreacion() %><br/>
        
        </p>
        <table border= "1">
            <caption><B>Informaci&oacute;n Registros Historial</B></caption>
            <tr>
                <th>ID</th>
                <th>Medico</th>
                <th>Contenido</th>
                <th>Fecha De Creaci&oacute;n Registro </th>
                <th>Fecha De Modificaci&oacute;n Registro </th>
            </tr>
             <%
                    for(RegistroHistorial r :listRegistroHistorial ){
                       Medicos medico = r.getMedico();
                       
             %>
             
            <tr>
                <td><%= r.getId() %> </td>
                <td> <%=medico.getNombre()+" "+medico.getApellidos()+" NºColegiado:"+medico.getNColegiado() %> </td>
                <td> <%= r.getContenido() %></td>      
                <td><%= r.getFechaCreacion() %> </td>
                <td><%= r.getFechaModificacion() %></td>
            </tr>
            <% } %>
        </table>
        <a href='index.jsp'> Volver</a>
    </body>
</html>
