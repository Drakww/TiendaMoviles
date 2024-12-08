/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.modelo;

import gm.tm.patrones_comportamiento.state.EstadoPedido;
import gm.tm.patrones_comportamiento.state.Pendiente;

/**
 *
 * @author jorge
 */
public class Pedido {
    private EstadoPedido estado;
    
    public Pedido() {
        this.estado = new Pendiente();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void procesar() {
        estado.manejar(this);
    }
}
