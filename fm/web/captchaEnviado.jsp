<%-- 
    Document   : captchaEnviado
    Created on : 8/03/2015, 02:50:02 AM
    Author     : kennross
--%>

<%@page import="nl.captcha.Captcha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);

            request.setCharacterEncoding("UTF-8");
            String respuesta = (request.getParameter("answer")).toLowerCase();
            if (captcha.isCorrect(respuesta)) {
                request.getServletContext().getRequestDispatcher("/GestionUsuarios").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/index.jsp?#modalRegistrarse").forward(request, response);
            }
        %>
    </body>
</html>
