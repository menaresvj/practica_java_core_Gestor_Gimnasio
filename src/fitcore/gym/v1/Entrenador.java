/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitcore.gym.v1;

import java.util.ArrayList;

/**
 *
 * @author vicente
 */
public class Entrenador {
    private int rut;
    private String nombre, apellido, especialidad;
    private ArrayList<Socio> sociosAsignados = new ArrayList<>();

    public Entrenador() {
    }

    public Entrenador(int rut, String nombre, String apellido, String especialidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Socio> getSociosAsignados() {
        return sociosAsignados;
    }

    public void setSociosAsignados(ArrayList<Socio> sociosAsignados) {
        this.sociosAsignados = sociosAsignados;
    }

    @Override
    public String toString() {
        return "Entrenador: Rut: " + rut + ". Nombre: " + nombre + ". Apellido: " + apellido + ". Especialidad: " + especialidad + ". Socios asignados: " + listarSociosNombre();
    }
    
    
    
    // métodos custom
    
    public void agregarSocio(Socio socio) {
        this.sociosAsignados.add(socio);
    }
    
    public void removerSocio(Socio socio) {
        sociosAsignados.remove(socio);
    }
    
    public void listarSocios() {
        for (Socio socio : sociosAsignados) {
            System.out.println(socio);
        }
    }
    
    public String listarSociosNombre() {
        if (sociosAsignados.isEmpty()) {
            return "ninguno.";
        }
        String listaSociosNombre = "";
        for (Socio socio : sociosAsignados) {
            listaSociosNombre += socio.getNombre() + " " + socio.getApellido() + ". ";
        }
        return listaSociosNombre;
    }
    
}
