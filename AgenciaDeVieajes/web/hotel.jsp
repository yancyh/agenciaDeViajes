<%-- 
    Document   : hotel
    Created on : 01-21-2017, 08:25:57 PM
    Author     : Yancy
--%>

<%@page import="java.util.*"%>
<%@page import="modelo.Hotel"%>
<%@page import="modelo.CrudHotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoteles</title>
        <script Language='JavaScript'>
            function cargar(codHotel, nombre){
                document.frmHotel.codHotel.value=codHotel;
                document.frmHotel.nombre.value=nombre;
            }
        </script>
        <%
            if(request.getAttribute("valor") != null){
        %>
        <script>
            alert('<%= request.getAttribute("valor") %>');
        </script>
        <%
            }
        %>
    </head>
    <%
        CrudHotel crud=new CrudHotel();
    %>
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
                cerrar="<a href='index.jsp'>Regresar al menú</a>";
            }
        %>
        <h4>Usuario: <% out.println(usuario); %></h4>
        <h5><% out.print(cerrar); %></h5>
        <center>
            <h1>Mantenimiento de hoteles</h1>
            <table border="2">
            <form action="procesarHotel" name="frmHotel" method="POST">
                <tr>
                    <%
                    CrudHotel obj=new CrudHotel();
                    Object n=obj.contarHoteles(obj);
                    %>
                    <td>Codigo:</td>
                    <td><input type="text" name="codHotel" value="<%=n%>"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="insertar" value="Insertar">
                        <input type="submit" name="modificar" value="Modificar">
                        <input type="submit" name="eliminar" value="Eliminar">
                        <input type="reset" name="limpiar" value="Limpiar">
                    </td>
                </tr>
            </form>
            </table>
            <br>
            <br>
            <hr>
            <table border="2">
                <thead>
                  <tr>
                      <th>Codigo  Hotel</th>
                      <th>Nombre</th>
                  </tr>
                </thead>
              <tbody>
                  <%
                  List<Hotel> lst2=crud.mostrarHotel();
                  for(Hotel ve:lst2){
                  %>
                  <tr>
                      <td><%= ve.getCodHotel()%></td>
                      <td><%= ve.getNombre()%></td>
'                      <td><a href="javascript:cargar('<%=ve.getCodHotel() %>','<%=ve.getNombre()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
          </table>
        </center>
    </body>
</html>
