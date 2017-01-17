

package modelo;
import conexion.ConexionBd;
import java.sql.*;

/**
 *
 * @author Yancy
 */
public class UsuarioIngreso {
    ConexionBd con = new ConexionBd();
    
    public boolean autenticarUsuario(String usuario, String contrasena)
    {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        try{
            String sql="select * from usuario where userName=? and clave=?";
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setString(1,usuario);
            pst.setString(2, contrasena);
            rs=pst.executeQuery();
            if(rs.absolute(1)){
                return true;
            }
            rs.close();
            pst.close();
            cn.close();
        }catch(Exception e){
            System.err.println("Error");
        }
        return false;
    }
    
    
}
