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
public class DescuentoDecorator extends ProductoDecorator {

    private double descuento;

    public DescuentoDecorator(Producto producto, double descuento) {
        super(producto);
        this.descuento = descuento;
    }

    @Override
    public double getPrecio() {
        double precioOriginal = producto.getPrecio();
        double precioConDescuento = precioOriginal - (precioOriginal * (descuento / 100));
        System.out.println("Precio original: " + precioOriginal);
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("Precio con descuento: " + precioConDescuento);
        return precioConDescuento;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " (Descuento aplicado: " + descuento + "%)";
    }

}
