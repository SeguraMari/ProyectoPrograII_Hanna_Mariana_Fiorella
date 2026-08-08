
package datos;

/**
 *
 * @author Graciela
 */
public class Propietario {
    
    private String cedPropietario;
    private String nomPropietario;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;
    

    public Propietario() {
    }
   
    

    public Propietario(String cedPropietario, String nomPropietario, String genero, String direccion, String telefono, String email) {
        this.cedPropietario = cedPropietario;
        this.nomPropietario = nomPropietario;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCedPropietario() {
        return cedPropietario;
    }

    public void setCedPropietario(String cedPropietario) {
        this.cedPropietario = cedPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
    
}
