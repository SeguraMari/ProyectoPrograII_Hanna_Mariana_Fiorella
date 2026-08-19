
package clases;

/**
 * Representa la información de un propietario dentro del sistema GuanaRent.
 * @author
 * @author
 * @author
 */
public class Propietario {

    // PASO 1: Se crea la clase

    // PASO 2: Se crean los atributos
    private int cedPropiet;
    private String nomPropiet;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase.
     */
    public Propietario() {
    }

    /**
     * Construye un propietario con todos sus datos.
     *
     * @param cedPropiet cédula del propietario.
     * @param nomPropiet nombre del propietario.
     * @param genero género del propietario.
     * @param direccion dirección del propietario.
     * @param telefono teléfono del propietario.
     * @param email correo electrónico del propietario.
     */
    public Propietario(int cedPropiet, String nomPropiet, String genero, String direccion, String telefono, String email) {
        this.cedPropiet = cedPropiet;
        this.nomPropiet = nomPropiet;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene la cédula del propietario.
     *
     * @return cédula del propietario.
     */
    public int getCedPropiet() {
        return cedPropiet;
    }

    /**
     * Establece la cédula del propietario.
     *
     * @param cedPropiet nueva cédula del propietario.
     */
    public void setCedPropiet(int cedPropiet) {
        this.cedPropiet = cedPropiet;
    }

    /**
     * Obtiene el nombre del propietario.
     *
     * @return nombre del propietario.
     */
    public String getNomPropiet() {
        return nomPropiet;
    }

    /**
     * Establece el nombre del propietario.
     *
     * @param nomPropiet nuevo nombre del propietario.
     */
    public void setNomPropiet(String nomPropiet) {
        this.nomPropiet = nomPropiet;
    }

    /**
     * Obtiene el género del propietario.
     *
     * @return género del propietario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del propietario.
     *
     * @param genero nuevo género del propietario.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección del propietario.
     *
     * @return dirección del propietario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del propietario.
     *
     * @param direccion nueva dirección del propietario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono del propietario.
     *
     * @return teléfono del propietario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del propietario.
     *
     * @param telefono nuevo teléfono del propietario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del propietario.
     *
     * @return correo electrónico del propietario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del propietario.
     *
     * @param email nuevo correo electrónico del propietario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // PASO 5: Se crean los métodos de clase
    // (Sin métodos de comportamiento propios en esta clase por el momento.)

}
