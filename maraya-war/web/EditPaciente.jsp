<%-- 
    Document   : EditPaciente
    Created on : 24-abr-2014, 11:21:04
    Author     : FranciscoJesús
--%>

<%@page import="maraya.entity.Historial"%>
<%@page import="java.util.ArrayList"%>
<%@page import="maraya.entity.RegistroHistorial"%>
<%@page import="java.util.List"%>
<%@page import="maraya.entity.UsuariosMedicos"%>
<%@page import="maraya.entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Historial</title>
    </head>
    <body>
        <br>
        <%
            String tipoUser;
            if (session.getAttribute("tipoUsuario") != null) {
                tipoUser = (String) session.getAttribute("tipoUsuario");
                if (tipoUser.equals("medico")) {
                    RegistroHistorial registro = (RegistroHistorial) request.getAttribute("Registro");
                    if (registro != null) {
                        request.setAttribute("Regist", registro);
        %>
                        <h1>Modificar Historial Paciente</h1>
                        <form method="post" action="EditPaciente">
                            <textarea name="textarea" rows="15" cols="40"><%=registro.getContenido()%></textarea>
                            <br>
                            <input type="submit" name="submit" />
                            <input type="hidden" name="ID" value="<%=registro.getId()%>"/>
                            <input type="hidden" name="idHistorial" value="<%=registro.getHistorial().getId()%>"/>
                        </form>
                        <a href="<%= request.getContextPath()%>/RegistrosPaciente?historial=<%= registro.getHistorial().getId()%>"> Volver </a>
        <%
                    } else {

        %>
                    <h1>Tienes que elegir un registro</h1>
                    <a href ="index.jsp">Volver</a>
                    <% }
                } else {
        %>
                    <h1>No tienes permiso para acceder aquí</h1>
                    <a href ="index.jsp">Volver</a>
        <%      }
            } else {
        %>
                <h1>No tienes permiso para acceder aquí</h1>
                <a href ="index.jsp">Volver</a>
        <% } %>
    </body>
</html>
