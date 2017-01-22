

package modelo;

import conexion.ConexionBd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yancy
 */
public class CrudAerolinea {
    ConexionBd con = new ConexionBd();
    
    public List<Aerolinea> mostrarAerolinea(){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<Aerolinea> lst = new ArrayList();
        String sql = "SELECT * FROM aerolinea";
        try{
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                lst.add(new Aerolinea(rs.getString("codAerolinea"),
                                      rs.getString("nombre")));
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return lst;
    } // fin mostrarAerolinea
    
    
    public String insertarAerolinea(Object obj){
        String resp = null;
        Connection cn;
        PreparedStatement pst;
        String sql = "INSERT INTO aerolinea VALUES (?,?)";
        Aerolinea aer = (Aerolinea)obj;
        try{
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            
            pst.setString(1,aer.getCodAerolinea());
            pst.setString(2,aer.getNombre());
            
            pst.executeUpdate();
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    } //fin insertarAerolinea
    
    
    public void modificarAerolinea(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql = "UPDATE aerolinea SET nombre=? WHERE codAerolinea=?";
        Aerolinea aer = (Aerolinea)obj;
        try {
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            //Mandar cada uno de los valores pertenecientes a la clase producto para poder modificar.
            
            pst.setString(1, aer.getNombre());
            pst.setString(2, aer.getCodAerolinea());
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    } //fin modificarAerolinea
    
    
    public void eliminarAerolinea(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql = "DELETE FROM aerolinea WHERE codAerolinea=?";
        Aerolinea aer = (Aerolinea)obj;
        try {
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setString(1,aer.getCodAerolinea());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    } //fin eliminarAerolinea
    
    
    public List<Aerolinea> listarAerolineas(){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<Aerolinea> lst = new ArrayList();
        String sql = "SELECT * FROM aerolinea";
        try{
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                lst.add(new Aerolinea(rs.getString("codAerolinea"), 
                                      rs.getString("nombre")));
            }
            rs.close();
            pst.close();
            cn.close();
     }catch(Exception e) {
        e.printStackTrace();
     }
     return lst;
    } //fin listarAerolineas
    
    
    public int contarAerolineas(Object obj){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        int cant = 0;
        String sql = "SELECT COUNT(*) AS cantidad FROM aerolinea";
        try{
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                cant=rs.getInt("cantidad")+1;
            }
            rs.close();
            pst.close();
            cn.close();
     }   catch(Exception e) {
         e.printStackTrace();
     }
     return cant;
    } //fin contarAerolineas
    
    
}
