<%-- 
    Document   : MostrarRegistros
    Created on : 25-abr-2014, 11:06:24
    Author     : Daniel Guerrero Salas
--%>

<%@page import="maraya.entity.RegistroHistorial"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            ArrayList<RegistroHistorial> lsRegistros = (ArrayList<RegistroHistorial>) request.getAttribute("listaRegistros");
         %>
        <table border="10">
            <caption> Registros</caption>
		<tr>
                        <th>Fecha de creacion</th>
                        <th>Fecha de modificacion</th>
			<th>Contenido</th>
                        <th>ID</th>
                        <th>Editar</th>
		</tr>
                <%
                    for(RegistroHistorial r : lsRegistros){
                       
                %>
                <tr>
                        <td><%=r.getFechaCreacion()  %></td>
                        <td><%= r.getFechaModificacion() %> </td>
			<td><%= r.getContenido()%> </td>
                        <td><%= r.getId()%> </td>
                        <td><a href="EditPaciente?Historial=<%=r.getId()%>"> Editar Registro</a></td>
                </tr>
                <%
                    }
                %>                
         </table>
          <a href="<%= request.getContextPath()%>/ConsultarHistorialesMedicos"> Volver </a>
          
         
    </body>
</html>
