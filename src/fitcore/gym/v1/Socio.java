/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitcore.gym.v1;

/**
 *
 * @author vicente
 */
public class Socio {
    private String nombre, apellido;
    private int edad, rut;
    private Membresia membresia;

    public Socio() {
    }

    public Socio(String nombre, String apellido, int edad, int rut, Membresia membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.rut = rut;
        this.membresia = membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    
    

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Socio: Rut: " + rut + ". Nombre: " + nombre + ". Apellido: " + apellido + ". Edad: " + edad + ". Membresía: " + membresia;
    }
    
    // métodos custom
    
}
