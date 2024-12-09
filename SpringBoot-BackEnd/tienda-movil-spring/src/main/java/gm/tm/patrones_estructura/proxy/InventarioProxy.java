/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.proxy;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */


@Service
public class InventarioProxy implements InventarioServicio{

    private final InventarioServicio inventarioReal;

    @Autowired
    public InventarioProxy(InventarioServiceImpl  inventarioReal) {
        this.inventarioReal = inventarioReal;
    }
    
    @Override
    public void actualizarStock(Integer productoId, int nuevaCantidad) {
        if (verificarPermisos()) {
            inventarioReal.actualizarStock(productoId, nuevaCantidad);
        } else {
            throw new SecurityException("No tiene permisos para actualizar el inventario.");
        }
    }

    private boolean verificarPermisos() {
        // Simular verificación de permisos (ejemplo: rol de usuario)
        // Esto podría ser más avanzado usando un contexto de usuario o token
        System.out.println("Verificando permisos para actualizar el inventario...");
        return true; // Cambiar a false para probar la protección.
    }
    
}
