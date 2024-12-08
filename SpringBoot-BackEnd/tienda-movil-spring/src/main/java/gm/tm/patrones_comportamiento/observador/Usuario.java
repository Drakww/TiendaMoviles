/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.observador;

import lombok.AllArgsConstructor;

/**
 *
 * @author jorge
 */
@AllArgsConstructor
public class Usuario implements Observador{

    private String nombre;
    
    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + "recibió notificación: " + mensaje);
    }
    
}
