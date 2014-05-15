<%-- 
    Document   : error.jsp
    Created on : 15-may-2014, 21:06:43
    Author     : Portatil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error!</h1>
        <% ArrayList<String> errores = (ArrayList<String>) request.getAttribute("Errores"); %>
        <% if(errores.size() != 0){ %>
        <div>
                <% for(String error : errores){ %>
                 <p><%= error %></p>
                <% } %>
            
        </div>
        <% } %>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
