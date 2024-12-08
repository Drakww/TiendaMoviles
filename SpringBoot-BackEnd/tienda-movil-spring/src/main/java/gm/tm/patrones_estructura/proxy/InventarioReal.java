/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.proxy;

/**
 *
 * @author jorge
 */
public class InventarioReal implements Inventario{

    @Override
    public void actualizarStock(Integer productoId, int nuevaCantidad) {
        // Actualiza el stock en la base de datos
    }
    
}
