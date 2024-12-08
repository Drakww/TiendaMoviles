/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.dto;

/**
 *
 * @author jorge
 */
public class DecoracionDTO {
    private double descuento; // Porcentaje de descuento
    private double garantiaExtendida; // Costo de la garantía extendida

    // Constructor vacío (necesario para la deserialización JSON)
    public DecoracionDTO() {
    }

    // Constructor principal
    public DecoracionDTO(double descuento, double garantiaExtendida) {
        this.descuento = descuento;
        this.garantiaExtendida = garantiaExtendida;
    }

    // Getters y Setters
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getGarantiaExtendida() {
        return garantiaExtendida;
    }

    public void setGarantiaExtendida(double garantiaExtendida) {
        this.garantiaExtendida = garantiaExtendida;
    }
}
