/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.servicio;

/**
 *
 * @author jorge
 */
public class UsuarioServicio {

    public void verificarUsuario(int usuarioId) {
        System.out.println("Verificando usuario con ID: " + usuarioId);
        // Simulación de validación
        if (usuarioId <= 0) {
            throw new IllegalArgumentException("Usuario no válido.");
        }
    }
}
