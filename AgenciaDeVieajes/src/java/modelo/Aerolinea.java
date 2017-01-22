

package modelo;

/**
 *
 * @author Yancy
 */
public class Aerolinea {
    private String codAerolinea;
    private String nombre;

    public Aerolinea() {
    }

    public Aerolinea(String codAerolinea, String nombre) {
        this.codAerolinea = codAerolinea;
        this.nombre = nombre;
    }

    public String getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(String codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
