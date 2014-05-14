<%@page import="java.io.PrintWriter"%>
<%@page import="maraya.entity.UsuariosPacientes"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Maraya</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Maraya</h1>
        <!-- <div>TODO write content</div> -->
        <% 
            HttpSession miSesion = request.getSession(true);
            Object user = null;
            user = miSesion.getAttribute("usuario");
            
            //out.println("Tipo: " + (String)miSesion.getAttribute("tipoUsuario") + "<br>");
            
            if(user == null){
                //out.println("El usuario aun no esta identificado");
                %>
                <div>
                    <a href='loginUsuario.jsp'> Login de usuario</a>
                    <br>
                    <a href='loginMedico.jsp'> Login de medico</a>
                </div>
                <%
            }else{
                
                String tipoUser = (String)miSesion.getAttribute("tipoUsuario");
                
                if(tipoUser == "paciente"){
                    %>
                    <a href='HistorialPaciente'> Consultar historial </a>
                    <%
                }else if(tipoUser == "medico"){
                    %>
                    <a href='ConsultarHistorialesMedicos'> Consultar historiales de los pacientes </a>
                    <%
                }
                
                %> 
                <br>
                <a href='Logout'> Logout </a> 
                <%
                
                //out.println("Hola, " + user.getUser());
                //out.println("<a href='Logout'> Logout </a>");
            }
        %>
    </body>
</html>
