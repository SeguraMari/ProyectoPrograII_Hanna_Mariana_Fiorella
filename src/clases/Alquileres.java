
package clases;

import java.time.LocalDate;

/**
 * Representa el registro de un alquiler dentro del sistema GuanaRent.
 *
 * @author 
 * @author  
 * @author 
 * 
 */


// PASO 1: Se crea la clase
public class Alquileres {

    // PASO 2: Se crean los atributos
    private int numAlquiler;
    private LocalDate fechContrato;
    private int cantMeses;
    private int numAdultos;
    private int numNinos;
    private double depositoGarantia;
    private double precioAlquiler;
    private double porcIncremAnual;
    private Inquilino inquilino;
    private Vivienda vivienda;
    private String estado;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase.
     */
    public Alquileres() {
    }

    /**
     * Construye un alquiler con todos sus datos.
     *
     * @param numAlquiler número consecutivo y único del alquiler.
     * @param fechContrato fecha de firma del contrato de alquiler.
     * @param cantMeses cantidad de meses de vigencia del contrato.
     * @param numAdultos cantidad de personas adultas que vivirán en la vivienda.
     * @param numNinos cantidad de niños que vivirán en la vivienda.
     * @param depositoGarantia monto pagado por adelantado como garantía.
     * @param precioAlquiler precio de alquiler mensual pactado.
     * @param porcIncremAnual porcentaje de incremento anual del precio de alquiler.
     * @param inquilino inquilino que arrendará la vivienda.
     * @param vivienda vivienda que se da en alquiler.
     * @param estado estado del contrato de alquiler.
     */
    public Alquileres(int numAlquiler, LocalDate fechContrato, int cantMeses, int numAdultos, int numNinos, double depositoGarantia, double precioAlquiler, double porcIncremAnual, Inquilino inquilino, Vivienda vivienda, String estado) {
        this.numAlquiler = numAlquiler;
        this.fechContrato = fechContrato;
        this.cantMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.inquilino = inquilino;
        this.vivienda = vivienda;
        this.estado = estado;
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene el número consecutivo del alquiler.
     *
     * @return número del alquiler.
     */
    public int getNumAlquiler() {
        return numAlquiler;
    }

    /**
     * Establece el número consecutivo del alquiler.
     *
     * @param numAlquiler nuevo número del alquiler.
     */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    /**
     * Obtiene la fecha de firma del contrato de alquiler.
     *
     * @return fecha de firma del contrato.
     */
    public LocalDate getFechContrato() {
        return fechContrato;
    }

    /**
     * Establece la fecha de firma del contrato de alquiler.
     *
     * @param fechContrato nueva fecha de firma del contrato.
     */
    public void setFechContrato(LocalDate fechContrato) {
        this.fechContrato = fechContrato;
    }

    /**
     * Obtiene la cantidad de meses de vigencia del contrato.
     *
     * @return cantidad de meses de vigencia.
     */
    public int getCantMeses() {
        return cantMeses;
    }

    /**
     * Establece la cantidad de meses de vigencia del contrato.
     *
     * @param cantMeses nueva cantidad de meses de vigencia.
     */
    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }

    /**
     * Obtiene la cantidad de adultos que vivirán en la vivienda.
     *
     * @return cantidad de adultos.
     */
    public int getNumAdultos() {
        return numAdultos;
    }

    /**
     * Establece la cantidad de adultos que vivirán en la vivienda.
     *
     * @param numAdultos nueva cantidad de adultos.
     */
    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    /**
     * Obtiene la cantidad de niños que vivirán en la vivienda.
     *
     * @return cantidad de niños.
     */
    public int getNumNinos() {
        return numNinos;
    }

    /**
     * Establece la cantidad de niños que vivirán en la vivienda.
     *
     * @param numNinos nueva cantidad de niños.
     */
    public void setNumNinos(int numNinos) {
        this.numNinos = numNinos;
    }

    /**
     * Obtiene el monto del depósito de garantía del alquiler.
     *
     * @return monto del depósito de garantía.
     */
    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    /**
     * Establece el monto del depósito de garantía del alquiler.
     *
     * @param depositoGarantia nuevo monto del depósito de garantía.
     */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    /**
     * Obtiene el precio de alquiler mensual pactado.
     *
     * @return precio de alquiler mensual.
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    /**
     * Establece el precio de alquiler mensual pactado.
     *
     * @param precioAlquiler nuevo precio de alquiler mensual.
     */
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    /**
     * Obtiene el porcentaje de incremento anual del precio de alquiler.
     *
     * @return porcentaje de incremento anual.
     */
    public double getPorcIncremAnual() {
        return porcIncremAnual;
    }

    /**
     * Establece el porcentaje de incremento anual del precio de alquiler.
     *
     * @param porcIncremAnual nuevo porcentaje de incremento anual.
     */
    public void setPorcIncremAnual(double porcIncremAnual) {
        this.porcIncremAnual = porcIncremAnual;
    }

    /**
     * Obtiene el inquilino que arrienda la vivienda.
     *
     * @return inquilino del alquiler.
     */
    public Inquilino getInquilino() {
        return inquilino;
    }

    /**
     * Establece el inquilino que arrienda la vivienda.
     *
     * @param inquilino nuevo inquilino del alquiler.
     */
    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    /**
     * Obtiene la vivienda que se da en alquiler.
     *
     * @return vivienda del alquiler.
     */
    public Vivienda getVivienda() {
        return vivienda;
    }

    /**
     * Establece la vivienda que se da en alquiler.
     *
     * @param vivienda nueva vivienda del alquiler.
     */
    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    /**
     * Obtiene el estado del contrato de alquiler.
     *
     * @return estado del contrato de alquiler.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del contrato de alquiler.
     *
     * @param estado nuevo estado del contrato de alquiler.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // PASO 5: Se crean los métodos de clase
    // (Sin métodos de comportamiento propios en esta clase por el momento.)

}
