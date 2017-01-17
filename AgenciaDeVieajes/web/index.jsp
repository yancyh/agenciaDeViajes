<%-- 
    Document   : index
    Created on : 01-15-2017, 08:38:49 AM
    Author     : Yancy
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agencia de Viajes</title>
    </head>
    <body>
        <% 
            String cerrar="";
            HttpSession objSesion=request.getSession(false);
            String usuario=(String) objSesion.getAttribute("usuario");
            if(usuario.equals(""))
            {
                response.sendRedirect("registro.jsp");
            }
            else
            {
                cerrar="<a href='cerrarSesion.jsp'>Cerrar sesion</a>";
            }
        %>
        
        <h4>Bienvenido(a) <% out.println(usuario); %></h4>
        <h5><% out.print(cerrar); %></h5>
        
        <center><h1>Agencia de Viajes</h1></center>
        <hr>
        <br>
        <br>
        <table border='0'>
            <tr><td style="font-size:15;font-weight:bold;color:darkgoldenrod">Menú</td></tr>
            <tr><td><a href="cliente.jsp">Mantenimiento de Clientes</a></td></tr>
            <tr><td>Mantenimiento de reservaciones</td></tr>
        </table>
    </body>
</html>
