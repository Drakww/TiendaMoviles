/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Carrito;
import gm.tm.modelo.Producto;
import gm.tm.patrones_comportamiento.memento.CarritoMemento;
import gm.tm.patrones_creacionales.factorymeth.ProductoFactory;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */
@RestController
//http://localhost:8080/movil-app/carrito
@RequestMapping("movil-app/carrito")
@CrossOrigin(value = "http://localhost:5173")
public class MementoControlador {
    private Carrito carrito = new Carrito();
    private CarritoMemento ultimoEstado;
    
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarProducto(@RequestBody ProductoRequest productoDTO){
        Producto producto = ProductoFactory.crearProducto(productoDTO);
        carrito.agregarProducto(producto);
        return ResponseEntity.ok("Producto agregado al carrito.");
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarEstado() {
        ultimoEstado = carrito.guardar();
        return ResponseEntity.ok("Estado del carrito guardado.");
    }
    
    @PostMapping("/restaurar")
    public ResponseEntity<List<Producto>> restaurarEstado() {
        if (ultimoEstado != null) {
            carrito.restaurar(ultimoEstado);
            return ResponseEntity.ok(ultimoEstado.getEstado());
        }
        return ResponseEntity.badRequest().body(null);
    }
}
