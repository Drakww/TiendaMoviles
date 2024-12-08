/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.patrones_comportamiento.observador.ProductoObservable;
import gm.tm.patrones_comportamiento.observador.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */
@RestController
//http://localhost:8080/movil-app/notificaciones
@RequestMapping("movil-app/notificaciones")
@CrossOrigin(value = "http://localhost:5173")
public class NotificacionControlador {
    private ProductoObservable productoObservable = new ProductoObservable();
    
    @PostMapping("/suscribir")
    public ResponseEntity<String> suscribirUsuario(@RequestParam String nombreUsuario){
        Usuario usuario = new Usuario(nombreUsuario);
        productoObservable.agregarObservador(usuario);
        return ResponseEntity.ok("Usuario suscrito a notificaciones.");
    }
    
    @PostMapping("/notificar")
    public ResponseEntity<String> enviarNotificacion(@RequestParam String mensaje){
        productoObservable.notificar(mensaje);
        return ResponseEntity.ok("Notificaciones enviadas. ");
    }
}
