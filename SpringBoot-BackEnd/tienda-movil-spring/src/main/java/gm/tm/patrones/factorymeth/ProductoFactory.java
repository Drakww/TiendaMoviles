/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.factorymeth;

import gm.tm.patrones.Builder.ProductoBuilder;
import gm.tm.patrones.Builder.SmarthponeBuilder;
import gm.tm.patrones.Builder.TabletBuilder;

/**
 *
 * @author jorge
 */
public class ProductoFactory {
    public static ProductoBuilder<?> crearProducto(String tipo){
        if ("smartphone".equalsIgnoreCase(tipo)) {
            return new SmarthponeBuilder();
        } else if("tablet".equalsIgnoreCase(tipo)){
            return new TabletBuilder();
        } else{
            throw new IllegalAccessError("Tipo de producto no sportado/no encontrado:" + tipo);
        }
    }
}
