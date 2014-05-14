<%-- 
    Document   : loginUsuario
    Created on : 19-abr-2014, 2:29:45
    Author     : Portatil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Usuario</h1>
        <form method="post" action="LoginUsuario">
            <label for="usuario">Usuario</label>
            <input type="text" name="usuario">
            
            <label for="password">Contraseña</label>
            <input type="password" name="password">
            
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
