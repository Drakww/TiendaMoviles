/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.proxy;

import gm.tm.excepcion.RecursoNoEncontradoExcepcion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author jorge
 */
@AllArgsConstructor
@NoArgsConstructor
public class InventarioProxy implements Inventario{

    private InventarioReal inventarioReal;
    
    @Override
    public void actualizarStock(Integer productoId, int nuevaCantidad) {
        if (usuarioTienePermisos()) {
            inventarioReal.actualizarStock(productoId, nuevaCantidad);
        } else {
            throw new RecursoNoEncontradoExcepcion("No tienes permisos para realizar esta acción.");
        }
    }
    
    private boolean usuarioTienePermisos(){
        //Lógica de permisos
        return true;
    }
    
}
