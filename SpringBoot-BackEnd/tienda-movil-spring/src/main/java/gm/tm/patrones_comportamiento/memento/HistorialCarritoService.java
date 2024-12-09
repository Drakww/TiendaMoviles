/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.memento;

import java.util.Stack;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class HistorialCarritoService {
    private Stack<CarritoMemento> historial = new Stack<>();

    public void agregarMemento(CarritoMemento memento) {
        historial.push(memento);
    }

    public CarritoMemento obtenerUltimoMemento() {
        return historial.isEmpty() ? null : historial.pop();
    }
}
