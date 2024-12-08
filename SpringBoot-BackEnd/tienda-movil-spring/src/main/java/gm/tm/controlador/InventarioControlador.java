/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.patrones_estructura.proxy.Inventario;
import gm.tm.patrones_estructura.proxy.InventarioProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge//Patron Proxy
 */
@RestController
//http://localhost:8080/movil-app/inventario
@RequestMapping("movil-app/inventario")
@CrossOrigin(value = "http://localhost:5173")
public class InventarioControlador {
    private final Inventario inventario;
    
    public InventarioControlador(){
        this.inventario= new InventarioProxy();
    }
    
    @PutMapping("/actualizar-stock")
    public ResponseEntity<String> actualizarStock(@RequestParam Integer productoId, @RequestParam int nuevaCantidad){
        try {
            inventario.actualizarStock(productoId, nuevaCantidad);
            return ResponseEntity.ok("Stock actualizado con éxito");
        } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: " + e.getMessage());
        }
    }
}
