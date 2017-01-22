

package modelo;

/**
 *
 * @author Yancy
 */
public class Hotel {
    private String codHotel;
    private String nombre;

    public Hotel() {
    }

    public Hotel(String codHotel, String nombre) {
        this.codHotel = codHotel;
        this.nombre = nombre;
    }

    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
