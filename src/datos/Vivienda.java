/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Graciela
 */
public class Vivienda {
    
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

    public Vivienda() {
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMtsConstruct() {
        return mtsConstruct;
    }

    public void setMtsConstruct(double mtsConstruct) {
        this.mtsConstruct = mtsConstruct;
    }

    public double getMtsLote() {
        return mtsLote;
    }

    public void setMtsLote(double mtsLote) {
        this.mtsLote = mtsLote;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public boolean isCochera() {
        return cochera;
    }

    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    public int getCantHabitac() {
        return cantHabitac;
    }

    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    public double getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(double cantBanios) {
        this.cantBanios = cantBanios;
    }

    public String getCarretera() {
        return carretera;
    }

    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
