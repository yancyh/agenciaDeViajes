<%-- 
    Document   : aerolinea
    Created on : 01-19-2017, 08:52:00 PM
    Author     : Yancy
--%>

<%@page import="java.util.*"%>
<%@page import="modelo.Aerolinea"%>
<%@page import="modelo.CrudAerolinea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolineas</title>
        <script Language='JavaScript'>
            function cargar(codAerolinea, nombre){
                document.frmAerolinea.codAerolinea.value=codAerolinea;
                document.frmAerolinea.nombre.value=nombre;
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
        CrudAerolinea crud=new CrudAerolinea();
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
            <h1>Mantenimiento de aerolineas</h1>
            <table border="2">
            <form action="procesarAerolinea" name="frmAerolinea" method="POST">
                <tr>
                    <%
                    CrudAerolinea obj=new CrudAerolinea();
                    Object n=obj.contarAerolineas(obj);
                    %>
                    <td>Codigo:</td>
                    <td><input type="text" name="codAerolinea" value="<%=n%>"></td>
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
                      <th>Codigo  Aerolinea</th>
                      <th>Nombre</th>
                  </tr>
                </thead>
              <tbody>
                  <%
                  List<Aerolinea> lst2=crud.mostrarAerolinea();
                  for(Aerolinea ve:lst2){
                  %>
                  <tr>
                      <td><%= ve.getCodAerolinea()%></td>
                      <td><%= ve.getNombre()%></td>
'                      <td><a href="javascript:cargar('<%=ve.getCodAerolinea() %>','<%=ve.getNombre()%>')">Seleccionar</a></td>
                      </tr>
                   <%
                  }
                  %>
              </tbody>
          </table>
        </center>
    </body>
</html>
