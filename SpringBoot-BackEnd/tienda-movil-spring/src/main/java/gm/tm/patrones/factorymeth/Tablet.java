/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.factorymeth;

import gm.tm.modelo.Producto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author jorge
 */
@Entity
//JPA: usamos en el contexto de herencia de entindades
@DiscriminatorValue("tablet")
public class Tablet extends Producto{
    private double tamanoPantalla; // Tamaño de pantalla específico para la Tablet
    public Tablet(){
        super();
    }

    @Override
    public String getTipo() {
        return "tablet";
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }
    
    
    
   
    
}
