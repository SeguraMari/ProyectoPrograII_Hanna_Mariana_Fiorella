
package clases;

import java.time.LocalDate;

/**
 * Representa el recibo de una mensualidad de alquiler dentro del sistema GuanaRent.
 * @author 
 * @author  
 * @author 
 */
public class Mensualidades {

    // PASO 1: Se crea la clase

    // PASO 2: Se crean los atributos
    private int consecutivo;
    private int numAlquiler;
    private LocalDate fechCreacion;
    private String nomInquilino;
    private int mesCobro;
    private int anioActual;
    private double descuento;
    private double montoMes;
    private String estado;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase.
     */
    public Mensualidades() {
    }

    /**
     * Construye una mensualidad con todos sus datos.
     *
     * @param consecutivo número único y consecutivo del recibo de mensualidad.
     * @param numAlquiler número del alquiler del cual se genera la cuota mensual.
     * @param fechCreacion fecha en que se generó la mensualidad.
     * @param nomInquilino nombre del inquilino responsable del alquiler.
     * @param mesCobro mes del año que se cobra en el recibo (1 a 12).
     * @param anioActual año en curso de la mensualidad.
     * @param descuento descuento aplicado según la temporada.
     * @param montoMes cuota mensual a pagar.
     * @param estado estado actual de la mensualidad.
     */
    public Mensualidades(int consecutivo, int numAlquiler, LocalDate fechCreacion, String nomInquilino, int mesCobro, int anioActual, double descuento, double montoMes, String estado) {
        this.consecutivo = consecutivo;
        this.numAlquiler = numAlquiler;
        this.fechCreacion = fechCreacion;
        this.nomInquilino = nomInquilino;
        this.mesCobro = mesCobro;
        this.anioActual = anioActual;
        this.descuento = descuento;
        this.montoMes = montoMes;
        this.estado = estado;
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene el consecutivo del recibo de mensualidad.
     *
     * @return consecutivo de la mensualidad.
     */
    public int getConsecutivo() {
        return consecutivo;
    }

    /**
     * Establece el consecutivo del recibo de mensualidad.
     *
     * @param consecutivo nuevo consecutivo de la mensualidad.
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * Obtiene el número del alquiler asociado a la mensualidad.
     *
     * @return número del alquiler asociado.
     */
    public int getNumAlquiler() {
        return numAlquiler;
    }

    /**
     * Establece el número del alquiler asociado a la mensualidad.
     *
     * @param numAlquiler nuevo número de alquiler asociado.
     */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    /**
     * Obtiene la fecha en que se generó la mensualidad.
     *
     * @return fecha de creación de la mensualidad.
     */
    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    /**
     * Establece la fecha en que se generó la mensualidad.
     *
     * @param fechCreacion nueva fecha de creación de la mensualidad.
     */
    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    /**
     * Obtiene el nombre del inquilino responsable del alquiler.
     *
     * @return nombre del inquilino.
     */
    public String getNomInquilino() {
        return nomInquilino;
    }

    /**
     * Establece el nombre del inquilino responsable del alquiler.
     *
     * @param nomInquilino nuevo nombre del inquilino.
     */
    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino;
    }

    /**
     * Obtiene el mes que se cobra en el recibo.
     *
     * @return mes de cobro (1 a 12).
     */
    public int getMesCobro() {
        return mesCobro;
    }

    /**
     * Establece el mes que se cobra en el recibo.
     *
     * @param mesCobro nuevo mes de cobro (1 a 12).
     */
    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    /**
     * Obtiene el año en curso de la mensualidad.
     *
     * @return año de la mensualidad.
     */
    public int getAnioActual() {
        return anioActual;
    }

    /**
     * Establece el año en curso de la mensualidad.
     *
     * @param anioActual nuevo año de la mensualidad.
     */
    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual;
    }

    /**
     * Obtiene el descuento aplicado según la temporada.
     *
     * @return descuento aplicado.
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado según la temporada.
     *
     * @param descuento nuevo descuento aplicado.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene la cuota mensual a pagar.
     *
     * @return cuota mensual a pagar.
     */
    public double getMontoMes() {
        return montoMes;
    }

    /**
     * Establece la cuota mensual a pagar.
     *
     * @param montoMes nueva cuota mensual a pagar.
     */
    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes;
    }

    /**
     * Obtiene el estado actual de la mensualidad.
     *
     * @return estado actual de la mensualidad.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la mensualidad.
     *
     * @param estado nuevo estado de la mensualidad.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // PASO 5: Se crean los métodos de clase
    // (Sin métodos de comportamiento propios en esta clase por el momento.)

}
