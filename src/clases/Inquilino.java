package clases;

import java.time.LocalDate;

/**
 * Representa la información de un inquilino dentro del sistema GuanaRent.
 * @author
 * @author
 * @author
 */
public class Inquilino {

    // PASO 1: Se crea la clase
    // PASO 2: Se crean los atributos
    private int cedInqui;
    private String nomInqui;
    private String genero;
    private LocalDate fechNac;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase.
     */
    public Inquilino() {
    }

    /**
     * Construye un inquilino con todos sus datos.
     *
     * @param cedInqui cédula del inquilino.
     * @param nomInqui nombre del inquilino.
     * @param genero género del inquilino.
     * @param fechNac fecha de nacimiento del inquilino.
     * @param direccion dirección del inquilino.
     * @param telefono teléfono del inquilino.
     * @param email correo electrónico del inquilino.
     * @param ocupacion ocupación u oficio del inquilino.
     */
    public Inquilino(int cedInqui, String nomInqui, String genero, LocalDate fechNac, String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene la cédula del inquilino.
     *
     * @return cédula del inquilino.
     */
    public int getCedInqui() {
        return cedInqui;
    }

    /**
     * Establece la cédula del inquilino.
     *
     * @param cedInqui nueva cédula del inquilino.
     */
    public void setCedInqui(int cedInqui) {
        this.cedInqui = cedInqui;
    }

    /**
     * Obtiene el nombre del inquilino.
     *
     * @return nombre del inquilino.
     */
    public String getNomInqui() {
        return nomInqui;
    }

    /**
     * Establece el nombre del inquilino.
     *
     * @param nomInqui nuevo nombre del inquilino.
     */
    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    /**
     * Obtiene el género del inquilino.
     *
     * @return género del inquilino.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del inquilino.
     *
     * @param genero nuevo género del inquilino.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento del inquilino.
     *
     * @return fecha de nacimiento del inquilino.
     */
    public LocalDate getFechNac() {
        return fechNac;
    }

    /**
     * Establece la fecha de nacimiento del inquilino.
     *
     * @param fechNac nueva fecha de nacimiento del inquilino.
     */
    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

    /**
     * Obtiene la dirección del inquilino.
     *
     * @return dirección del inquilino.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del inquilino.
     *
     * @param direccion nueva dirección del inquilino.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono del inquilino.
     *
     * @return teléfono del inquilino.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del inquilino.
     *
     * @param telefono nuevo teléfono del inquilino.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del inquilino.
     *
     * @return correo electrónico del inquilino.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del inquilino.
     *
     * @param email nuevo correo electrónico del inquilino.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la ocupación del inquilino.
     *
     * @return ocupación del inquilino.
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * Establece la ocupación del inquilino.
     *
     * @param ocupacion nueva ocupación del inquilino.
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    // PASO 5: Se crean los métodos de clase
    // (Sin métodos de comportamiento propios en esta clase por el momento.)
}
