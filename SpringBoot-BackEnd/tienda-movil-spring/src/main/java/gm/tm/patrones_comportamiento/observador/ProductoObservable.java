/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.observador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class ProductoObservable {
    private List<Observador> observadores = new ArrayList<>();
    
    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }
    
    public void notificar(String mensaje){
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}
