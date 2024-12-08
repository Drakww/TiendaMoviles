/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.state;

import gm.tm.modelo.Pedido;

/**
 *
 * @author jorge
 */
public class Procesado implements EstadoPedido{

    @Override
    public void manejar(Pedido pedido) {
        System.out.println("El pedido ha sido procesado. ");
        pedido.setEstado(new Enviado());
    }

    
}
