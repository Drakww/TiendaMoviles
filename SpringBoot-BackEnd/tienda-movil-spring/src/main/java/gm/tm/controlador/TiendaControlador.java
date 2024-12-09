/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;



import gm.tm.modelo.Producto;

import gm.tm.patrones_estructura.facade.TiendaFacade;
import gm.tm.patrones_estructura.proxy.InventarioProxy;
import gm.tm.patrones_estructura.proxy.InventarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */
@RestController
//http://localhost:8080/movil-app
@RequestMapping("movil-app")
@CrossOrigin(value = "http://localhost:5173")

public class TiendaControlador {
    
    private final TiendaFacade tiendaFacade;
    private final InventarioServicio inventarioServicio; 
    
    
    @Autowired
    public TiendaControlador(TiendaFacade tiendaFacade, InventarioProxy invetarioServicio){
        this.tiendaFacade = tiendaFacade;
        this.inventarioServicio = invetarioServicio;
    }
    
    //Obtener catálogo de productos
    @GetMapping("/catalogo")
    public List<Producto> obtenerCatalogo() {
        var productos = tiendaFacade.obtenerCatalogo();
        return productos;
    }
    
    
    //Cambiar el stock solo por personal autorizado
    @PutMapping("/{productoId}/actualizar")
    public ResponseEntity<String> actualizarStock(@PathVariable Integer productoId, @RequestParam int nuevaCantidad) {
        try {
            tiendaFacade.actualizarStock(productoId, nuevaCantidad);
            return ResponseEntity.ok("Stock actualizado exitosamente.");
        } catch (SecurityException e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor: " + e.getMessage());
        }
    }
    
    
}
