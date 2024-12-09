/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.proxy;

import gm.tm.modelo.Producto;
import gm.tm.servicio.ProductoServicio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class InventarioServiceImpl implements InventarioServicio {

    private final ProductoServicio productoServicio;

    @Autowired
    public InventarioServiceImpl(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @Override
    @Transactional
    public void actualizarStock(Integer productoId, int nuevaCantidad) {
        // Usar el servicio de usuario para buscar el producto por ID
        Producto producto = productoServicio.buscarProductoPorId(productoId);

        if (producto != null) {
            // Actualizar la cantidad en stock
            producto.setStock(nuevaCantidad);

            // Guardar el producto con la nueva cantidad
            productoServicio.guardarProducto(producto); // Asegúrate de tener un método para guardar el producto
            System.out.println("Stock actualizado en base de datos para el producto con ID: " + productoId);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

}
