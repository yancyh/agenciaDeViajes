

package conexion;

/**
 *
 * @author Yancy
 */
public class ConexionBd {
    private String user;
    private String driver;
    private String pass;
    private String url;

    public ConexionBd() {
        this.user = "root";
        this.driver = "com.mysql.jdbc.Driver";
        this.pass = "Itca123!";
        this.url = "jdbc:mysql://localhost:3306/reservas_hotel";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
