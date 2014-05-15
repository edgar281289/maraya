<%-- 
    Document   : formularioNuevoPaciente
    Created on : 15-may-2014, 15:09:00
    Author     : Edgar Pérez Ferrando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- evaluar si hay un medico en la sesion -->
        <%
            HttpSession miSesion = request.getSession(true);
            Object user = null;
            user = miSesion.getAttribute("usuario");
            String tipoUser = (String)miSesion.getAttribute("tipoUsuario");
            if(user == null){
                %>
                <p>No se ha iniciado sesi&oacute;n</p>
                <a href="index.jsp">Volver al inicio</a>
                <%        
            }else if(tipoUser == null || "".equals(tipoUser) || "paciente".equals(tipoUser)){
                %>
                <p>No tiene permisos para acceder aqu&iacute;</p>
                <a href="index.jsp">Volver al inicio</a>
                <% 
            }else{
               
            %>
                <h1>Formulario de Usuario</h1>
                <div id="formularioUsuario">
                    <form method="post" action="registroPaciente">
                        <table>
                            <tr>
                                <td><label for="nombre">Nombre</label></td>
                                <td><input type="text" name="nombre"></td>
                            </tr>

                            <tr>
                                <td><label for="apellidos">Apellidos</label></td>
                                <td><input type="text" name="apellidos"></td>                        
                            </tr>

                            <tr>
                                <td><label for="dni">DNI</label></td>
                                <td><input type="text" name="dni"></td>
                            </tr>

                            <tr>
                                <td><label for="nss">NSS</label></td>
                                <td><input type="text" name="nss"></td>
                            </tr>

                            <tr>
                                <td><label for="telefono">Telefono</label></td>
                                <td><input type="text" name="telefono"></td>
                            </tr>

                            <tr>
                                <td><label for="email">Email</label></td>
                                <td><input type="text" name="email"></td>
                            </tr>

                            <tr>
                                <td><label for="fechaNacimiento">Fecha de nacimiento</label></td>
                                <td><input type="text" name="fechaNacimiento"></td>
                            </tr>

                            <tr>
                                <td><label for="provincia">Provincia</label></td>
                                <td><input type="text" name="provincia"></td>
                            </tr>

                            <tr>
                                <td><label for="codigoPostal">Codigo postal</label></td>
                                <td><input type="text" name="codigoPostal"></td>
                            </tr>

                            <tr>
                                <td><label for="ciudad">Ciudad</label></td>
                                <td><input type="text" name="ciudad"></td>
                            </tr>

                            <tr>
                                <td><input type="submit" value="Enviar"></td>
                                <td><input type="reset" value="Borrar"></td>
                            </tr>

                        </table>           
                    </form>
                </div>
                <% } %>
    </body>
</html>
