
package datos;

import java.time.LocalDate;

/**
 *
 * @author Graciela
 */
public class Inquilino {
    
    private int cedInqui;
    private String nomInqui;
    private String genero;
    private LocalDate fechaNac;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;

    public Inquilino() {
    }

    public Inquilino(int cedInqui, String nomInqui, String genero, LocalDate fechaNac, String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }

    public int getCedInqui() {
        return cedInqui;
    }

    public void setCedInqui(int cedInqui) {
        this.cedInqui = cedInqui;
    }

    public String getNomInqui() {
        return nomInqui;
    }

    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
    
    
    
    
    
}
