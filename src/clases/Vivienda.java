package clases;

/**
 * Representa la información de una vivienda dentro del sistema GuanaRent.
 * @author 
 * @author  
 * @author 
 */


// PASO 1: Se crea la clase
public class Vivienda {

    // PASO 2: Se crean los atributos
    private int idVivienda;
    private String descripcion;
    private String direccion;
    private double mtsConstruct;
    private double mtsLote;
    private String tipoConstruccion;
    private boolean cochera;
    private int cantHabitac;
    private double cantBanios;
    private String carretera;
    private double precioBase;
    private double depositoGarantia;
    private Propietario propietario; // Relación con la clase Propietario
    private String estado;

    // PASO 3: Se crean los constructores
    /**
     * Constructor vacío de la clase.
     */
    public Vivienda() {
    }

    /**
     * Construye una vivienda con todos sus datos.
     *
     * @param idVivienda identificación única de la vivienda.
     * @param descripcion descripción de la vivienda.
     * @param direccion dirección de la vivienda.
     * @param mtsConstruct metros cuadrados de construcción.
     * @param mtsLote metros cuadrados del lote.
     * @param tipoConstruccion tipo de construcción de la vivienda.
     * @param cochera indica si la vivienda tiene cochera.
     * @param cantHabitac cantidad de habitaciones.
     * @param cantBanios cantidad de baños.
     * @param carretera tipo de carretera de acceso.
     * @param precioBase precio base de alquiler.
     * @param depositoGarantia monto del depósito de garantía.
     * @param propietario propietario dueño de la vivienda.
     * @param estado estado actual de la vivienda.
     */
    public Vivienda(int idVivienda, String descripcion, String direccion, double mtsConstruct, double mtsLote, String tipoConstruccion, boolean cochera, int cantHabitac, double cantBanios, String carretera, double precioBase, double depositoGarantia, Propietario propietario, String estado) {
        this.idVivienda = idVivienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstruct = mtsConstruct;
        this.mtsLote = mtsLote;
        this.tipoConstruccion = tipoConstruccion;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }

    // PASO 4: Se crean los métodos get y set
    /**
     * Obtiene el identificador único de la vivienda.
     *
     * @return identificador de la vivienda.
     */
    public int getIdVivienda() {
        return idVivienda;
    }

    /**
     * Establece el identificador único de la vivienda.
     *
     * @param idVivienda nuevo identificador de la vivienda.
     */
    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * Obtiene la descripción de la vivienda.
     *
     * @return descripción de la vivienda.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la vivienda.
     *
     * @param descripcion nueva descripción de la vivienda.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la dirección de la vivienda.
     *
     * @return dirección de la vivienda.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la vivienda.
     *
     * @param direccion nueva dirección de la vivienda.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene los metros cuadrados de construcción.
     *
     * @return metros cuadrados de construcción.
     */
    public double getMtsConstruct() {
        return mtsConstruct;
    }

    /**
     * Establece los metros cuadrados de construcción.
     *
     * @param mtsConstruct nuevos metros cuadrados de construcción.
     */
    public void setMtsConstruct(double mtsConstruct) {
        this.mtsConstruct = mtsConstruct;
    }

    /**
     * Obtiene los metros cuadrados del lote.
     *
     * @return metros cuadrados del lote.
     */
    public double getMtsLote() {
        return mtsLote;
    }

    /**
     * Establece los metros cuadrados del lote.
     *
     * @param mtsLote nuevos metros cuadrados del lote.
     */
    public void setMtsLote(double mtsLote) {
        this.mtsLote = mtsLote;
    }

    /**
     * Obtiene el tipo de construcción de la vivienda.
     *
     * @return tipo de construcción de la vivienda.
     */
    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    /**
     * Establece el tipo de construcción de la vivienda.
     *
     * @param tipoConstruccion nuevo tipo de construcción de la vivienda.
     */
    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    /**
     * Indica si la vivienda tiene cochera.
     *
     * @return true si la vivienda tiene cochera.
     */
    public boolean isCochera() {
        return cochera;
    }

    /**
     * Establece si la vivienda tiene cochera.
     *
     * @param cochera true si la vivienda tiene cochera.
     */
    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    /**
     * Obtiene la cantidad de habitaciones de la vivienda.
     *
     * @return cantidad de habitaciones.
     */
    public int getCantHabitac() {
        return cantHabitac;
    }

    /**
     * Establece la cantidad de habitaciones de la vivienda.
     *
     * @param cantHabitac nueva cantidad de habitaciones.
     */
    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    /**
     * Obtiene la cantidad de baños de la vivienda.
     *
     * @return cantidad de baños.
     */
    public double getCantBanios() {
        return cantBanios;
    }

    /**
     * Establece la cantidad de baños de la vivienda.
     *
     * @param cantBanios nueva cantidad de baños.
     */
    public void setCantBanios(double cantBanios) {
        this.cantBanios = cantBanios;
    }

    /**
     * Obtiene el tipo de carretera de acceso a la vivienda.
     *
     * @return tipo de carretera de acceso.
     */
    public String getCarretera() {
        return carretera;
    }

    /**
     * Establece el tipo de carretera de acceso a la vivienda.
     *
     * @param carretera nuevo tipo de carretera de acceso.
     */
    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    /**
     * Obtiene el precio base de alquiler de la vivienda.
     *
     * @return precio base de alquiler.
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Establece el precio base de alquiler de la vivienda.
     *
     * @param precioBase nuevo precio base de alquiler.
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el monto del depósito de garantía de la vivienda.
     *
     * @return monto del depósito de garantía.
     */
    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    /**
     * Establece el monto del depósito de garantía de la vivienda.
     *
     * @param depositoGarantia nuevo monto del depósito de garantía.
     */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    /**
     * Obtiene el propietario dueño de la vivienda.
     *
     * @return propietario de la vivienda.
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Establece el propietario dueño de la vivienda.
     *
     * @param propietario nuevo propietario de la vivienda.
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Obtiene el estado actual de la vivienda.
     *
     * @return estado actual de la vivienda.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la vivienda.
     *
     * @param estado nuevo estado de la vivienda.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // PASO 5: Se crean los métodos de clase
    // (Sin métodos de comportamiento propios en esta clase por el momento.)

}
