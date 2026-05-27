/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fitcore.gym.v1;

import java.time.LocalDate;

/**
 *
 * @author vicente
 */
public class FitCoreGymV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // creación de la app de sistema
        Gimnasio gimnasio = new Gimnasio("Dojo Himura", 50);
        
        // creación de elementos de prueba
        Equipo equipoPrueba = new Equipo(1, "Pesa Vikinga", "fuerza", "operativo");
        gimnasio.agregarEquipo(equipoPrueba);
        Membresia membresiaNueva = new Membresia("mensual", 30000, LocalDate.now());
        Socio socioNuevo = new Socio("Goku", "Son", 25, 11111111, membresiaNueva);
        gimnasio.agregarSocio(socioNuevo);
        Membresia membresiaNueva2 = new Membresia("anual", 300000, LocalDate.now());
        Socio socioNuevo2 = new Socio("Vegeta", "IV", 27, 22222222, membresiaNueva2);
        gimnasio.agregarSocio(socioNuevo2);        
        
        // flujo principal
        System.out.println("Bienvenido a la app de VM. Gimnasio: " + gimnasio.getName() + ".");
        System.out.println("");
        
        gimnasio.flujoMenuPrincipal();
        
    }
 
}
