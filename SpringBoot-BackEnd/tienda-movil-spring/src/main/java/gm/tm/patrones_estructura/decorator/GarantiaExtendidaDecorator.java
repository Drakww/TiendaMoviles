/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.decorator;

import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
public class GarantiaExtendidaDecorator extends ProductoDecorator{
    
    private double costoGarantia;
    
    public GarantiaExtendidaDecorator(Producto producto, double costoGarantia) {
        super(producto);
        this.costoGarantia = costoGarantia;
    }
    
    @Override
    public double getPrecio() {
        return producto.getPrecio() + costoGarantia;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " (Incluye garantía extendida por " + costoGarantia + " USD)";
    }
    
}
