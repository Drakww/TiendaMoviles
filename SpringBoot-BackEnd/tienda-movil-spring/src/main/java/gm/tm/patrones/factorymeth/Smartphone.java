/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.factorymeth;

import gm.tm.modelo.Producto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jorge
 */
@Entity
//JPA: usamos en el contexto de herencia de entindades
@DiscriminatorValue("smarthphone")
public class Smartphone extends Producto{
    private int ram; //Memoria RAM especifica para el Smartphone
    @Override
    public String getTipo() {
        return "smartphone";
    }
    
    public int getRam(){
        return ram;
    }
    
    public void setRam(int ram){
        this.ram = ram;
    }
    
    
}
