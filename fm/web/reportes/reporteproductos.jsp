<%-- 
    Document   : reporteproductos
    Created on : 11/03/2015, 12:53:22 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="../img/favicon.ico">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <title>Productos del sistema</title>
    </head>
    <body class="container text-center">
        <br>
        <%
            HttpSession sesion = request.getSession(false);
            if (sesion.getAttribute("producto") != null) {


        %>
        <object type="application/pdf" data="http://localhost:8080/fm/Generador" width="1000" height="720"></object>
        <%            }
        %>
    </body>
</html>
