<%-- 
    Document   : cerrarSesion
    Created on : 01-15-2017, 10:42:39 AM
    Author     : Yancy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession objSesion =request.getSession();
    objSesion.invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesion cerrada</title>
    </head>
    <body>
        <h1>Cesion finalizada</h1>
    </body>
</html>
