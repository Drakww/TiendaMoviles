/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.modelo.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */
@RestController
//http://localhost:8080/movil-app/pedidos
@RequestMapping("movil-app/poedidos")
@CrossOrigin(value = "http://localhost:5173")
public class PedidoControlador {
    
    @PostMapping("/procesar")
    public ResponseEntity<String> procesarPedido(){
        Pedido pedido = new Pedido();
        pedido.procesar(); //Pendiente -> Procesado
        pedido.procesar(); //Procesado -> Enviado
        return ResponseEntity.ok("Pedido procesado y enviado. ");
    }
    
}
