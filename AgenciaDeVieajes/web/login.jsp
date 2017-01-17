<%-- 
    Document   : login
    Created on : 01-15-2017, 08:21:02 AM
    Author     : Yancy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
    <center><h1>Inicio de Sesion</h1></center>
    <center>
        <form action="iniciarSesion" method="post">
            <table border="1">
                <tr><td>Usuario</td>
                    <td><input type="text" name="txtUsu" required="true"></td>
                </tr>
                <tr><td>Contraseña</td>
                    <td><input type="password" name="txtPa" required="true"></td>
                </tr>
                <td colspan="2"><center><input type="submit" name="btnEnviar" value="Enviar"></center></td>
            </table>
        </form>
    </center>
    </body>
</html>
