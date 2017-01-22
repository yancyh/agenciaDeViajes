

package modelo;

import conexion.ConexionBd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yancy
 */
public class CrudHotel {
  
    ConexionBd con = new ConexionBd();
    
    public List<Hotel> mostrarHotel(){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<Hotel> lst = new ArrayList();
        String sql = "SELECT * FROM hotel";
        try{
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                lst.add(new Hotel(rs.getString("codHotel"),
                                  rs.getString("nombre")));
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return lst;
    } // fin mostrarHotel
    
    
    public String insertarHotel(Object obj){
        String resp = null;
        Connection cn;
        PreparedStatement pst;
        String sql = "INSERT INTO hotel VALUES (?,?)";
        Hotel htl = (Hotel)obj;
        try{
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            
            pst.setString(1,htl.getCodHotel());
            pst.setString(2,htl.getNombre());
            
            pst.executeUpdate();
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    } //fin insertarHotel
    
    
    public void modificarHotel(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql = "UPDATE hotel SET nombre=? WHERE codHotel=?";
        Hotel htl = (Hotel)obj;
        try {
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            //Mandar cada uno de los valores pertenecientes a la clase producto para poder modificar.
            
            pst.setString(1, htl.getNombre());
            pst.setString(2, htl.getCodHotel());
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    } //fin modificarHotel
    
    
    public void eliminarHotel(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql = "DELETE FROM hotel WHERE codHotel=?";
        Hotel htl = (Hotel)obj;
        try {
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setString(1,htl.getCodHotel());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    } //fin eliminarHotel
    
    
    public List<Hotel> listarHoteles(){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<Hotel> lst = new ArrayList();
        String sql = "SELECT * FROM hotel";
        try{
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                lst.add(new Hotel(rs.getString("codHotel"), 
                                  rs.getString("nombre")));
            }
            rs.close();
            pst.close();
            cn.close();
     }catch(Exception e) {
        e.printStackTrace();
     }
     return lst;
    } //fin listarHoteles
    
    
    public int contarHoteles(Object obj){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        int cant = 0;
        String sql = "SELECT COUNT(*) AS cantidad FROM hotel";
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
    } //fin contarHoteles
}
