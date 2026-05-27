/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitcore.gym.v1;

import java.time.LocalDate;


/**
 *
 * @author vicente
 */
public class Membresia {
    private String tipo;
    private int precio;
    private LocalDate fechaInicio;

    public Membresia() {
    }

    public Membresia(String tipo, int precio, LocalDate fechaInicio) {
        this.tipo = tipo;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ". Precio: " + precio + ". Fecha de inicio: " + fechaInicio + ".";
    }
    
    // métodos custom
    
    public void cambiarPrecioMembresia(int precioNuevo) {
        this.precio = precioNuevo;
    }
    
}
