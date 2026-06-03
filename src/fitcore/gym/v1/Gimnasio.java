/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitcore.gym.v1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vicente
 */
public class Gimnasio {
    
    // atributos
    private String name;
    private int capacidadMaxima;
    int idEquipo = 0;
    ArrayList<Equipo> listaEquipos = new ArrayList<>();
    ArrayList<Socio> listaSocios = new ArrayList<>();
    ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();

    // constructores
    public Gimnasio() {
    }

    public Gimnasio(String name, int capacidadMaxima) {
        this.name = name;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    // getters

    public String getName() {
        return name;
    }
    
    // métodos custom
    
    Scanner sc = new Scanner(System.in);

    public int escogerInt(String mensaje, int min, int max) {
        System.out.print(mensaje);
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine();
                if (numero < min || numero > max) {
                    System.out.print("Debe escoger un valor dentro del rango: ");
                } else {
                    return numero;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Debe escoger un número: ");
            }
        }
    }
    
    public String escogerString(String mensaje, int min, int max) {
        System.out.print(mensaje);
        while (true) {
            String texto = sc.nextLine();
            if (texto.length() < min || texto.length() > max) {
                System.out.print("Introduzca un texto dentro del rango válido (min: " + min + " carácteres, max: " + max + "): ");
            } else {
                return texto;
            }
        }
    }


    
    // MENÚ PRINCIPAL
    
    public void imprimirMenuPrincipal() {
        System.out.println();
        System.out.println("---Menú Principal---");
        System.out.println("1.- Menú equipo");
        System.out.println("2.- Menú socios");
        System.out.println("3.- Menú entrenadores");
        System.out.println("4.- Menú reportes");
        System.out.println("0.- Salir de la aplicación");
    }
    
    public void flujoMenuPrincipal() {
        while (true) {
            this.imprimirMenuPrincipal();
            int opcion = this.escogerInt("Escoja una opción: ", 0, 10);

            switch(opcion) {
                case 0:
                    System.out.println("Gracias por utilizar nuestra app.");
                    return; 

                case 1:
                    this.flujoMenuEquipos();
                    break;
                    
                case 2:
                    this.flujoMenuSocios();
                    break;
                    
                case 3:
                    flujoMenuEntrenadores();
                    break;
                    
                case 4:
                    flujoMenuReportes();
                    break;
            }     
        }
    }
    
    // EQUIPOS
    
    public void imprimirMenuEquipo() {
        System.out.println();
        System.out.println("---Menú Equipo---");
        System.out.println("1.- Agregar equipo");
        System.out.println("2.- Remover equipo");
        System.out.println("3.- Listar equipos");
        System.out.println("0.- Volver al Menú Principal");
    }    
    
    public void agregarEquipo(Equipo equipo) {
        this.listaEquipos.add(equipo);
        this.idEquipo = idEquipo+1;
    }
    
    public void flujoMenuEquipos() {
        while (true) {
            this.imprimirMenuEquipo();
            int opcion = this.escogerInt("Escoja una opcion: ", 0, 3);

            switch(opcion) {
                case 0: // volver al menú principal
                    return;

                case 1: // agregar equipo
                    String nombreEquipo = this.escogerString("Ingrese el nombre del equipo: ", 4, 30);
                    String tipoEquipo = this.escogerString("Ingrese el tipo: cardio / fuerza / estiramiento: ", 3, 20);
                    while (true) {
                        if (!tipoEquipo.equalsIgnoreCase("fuerza") && !tipoEquipo.equalsIgnoreCase("cardio") && !tipoEquipo.equalsIgnoreCase("estiramiento")) {
                            tipoEquipo = this.escogerString("Ingrese un tipo válido: cardio / fuerza / estiramiento: ", 5, 12);
                        } else {
                            break;
                        }
                    }
                    String estadoEquipo = this.escogerString("Ingrese el estado: operativo / en mantención / fuera de servicio: ", 3, 20);
                    while (true) {
                        if (!estadoEquipo.equalsIgnoreCase("operativo") && !estadoEquipo.equalsIgnoreCase("en mantención") && !estadoEquipo.equalsIgnoreCase("fuera de servicio")) {
                            estadoEquipo = this.escogerString("Ingrese un estado válido: operativo / en mantención / fuera de servicio: ", 3, 25);
                        } else {
                            break;
                        }
                    }
                    Equipo equipoAgregar = new Equipo(idEquipo+1, nombreEquipo, tipoEquipo, estadoEquipo);
                    this.agregarEquipo(equipoAgregar);
                    System.out.println("Se ha agregado el equipo " + nombreEquipo + " exitosamente.");
                    break;
                    
                case 2: // remover equipo
                    if (listaEquipos.isEmpty()) {
                        System.out.println("No se han agregado equipos.");
                    } else {
                        int idEquipoBorrar = this.escogerInt("Ingrese el ID del equipo que desea remover: ", 1, 100000);
                        boolean equipoEncontrado = false;
                        for (Equipo equipo : listaEquipos) {
                            if (idEquipoBorrar == equipo.getId()) {
                                System.out.println("Equipo encontrado: " + equipo);
                                equipoEncontrado = true;
                                String respuesta = escogerString("¿Desea remover el equipo " + equipo.getNombre() + "?: Ingrese S o N: ", 1, 2);
                                if (respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Si") || respuesta.equalsIgnoreCase("Sí")) {
                                    this.listaEquipos.remove(equipo);
                                    System.out.println("El equipo se ha eliminado exitosamente.");
                                    break;
                                } else {
                                    System.out.println("Operación cancelada.");
                                }
                            }
                        }
                        if (equipoEncontrado == false) {
                            System.out.println("No se ha encontrado un equipo con dicho Id. Operación cancelada.");
                        }                        
                    }
                    break;

                case 3: // listar equipos
                    listarEquipos();
                    break;
            }        
        }
    }
    
    
    // SOCIOS
    
    public void imprimirMenuSocios() {
        System.out.println("");
        System.out.println("---Menú Socios---");
        System.out.println("1.- Agregar socio");
        System.out.println("2.- Remover socio");
        System.out.println("3.- Modificar membresía de un socio");
        System.out.println("4.- Listar socios");
        System.out.println("0.- Volver al menú principal");
    }
    
    public void listarSocios() {
        if (listaSocios.isEmpty()) {
            System.out.println("No se han registrado socios.");
        } else {
            for (Socio socio : listaSocios) {
                System.out.println(socio);
            }
        }
    }
    
    public void agregarSocio(Socio socio) {
        this.listaSocios.add(socio);
    }
    
    public Socio buscarSocioRut(int rut) {
        for (Socio socio : listaSocios) {
            if (rut == socio.getRut()) {
                return socio;
            }
        }
        return null;
    }
    
    public Socio buscarSocioRutEntrenador(int rut, Entrenador entrenador) {
        for (Socio socio : entrenador.getSociosAsignados()) {
            if (rut == socio.getRut()) {
                return socio;
            }
        }
        return null;
    }
    
    public void flujoMenuSocios() {
        while (true) {
            imprimirMenuSocios();
            int opcion = escogerInt("Escoja una opción: ", 0, 4);
            
            switch (opcion) {
                case 0: // volver al menú principal
                    return;
                    
                case 1: // agregar socio
                    String nombreSocio = escogerString("Ingrese el nombre del nuevo socio: ", 2, 20);
                    String apellidoSocio = escogerString("Ingrese el apellido del nuevo socio: ", 2, 20);
                    int edadSocio = escogerInt("Ingrese la edad del nuevo socio: ", 8, 120);
                    int rutSocio = escogerInt("Ingrese el rut del nuevo socio: ", 10000000, 99999999);
                    String tipoMensualidad = "";
                    if (buscarSocioRut(rutSocio) != null){
                        System.out.println("Ya existe un socio con ese rut. Operación cancelada.");
                        break;
                    } else {
                        tipoMensualidad = escogerString("Ingrese el tipo de membresía del socio nuevo (mensual / semestral / anual): ", 4, 25);
                        while (!tipoMensualidad.equalsIgnoreCase("mensual") && !tipoMensualidad.equalsIgnoreCase("semestral") && !tipoMensualidad.equalsIgnoreCase("anual")) {
                            tipoMensualidad = escogerString("Ingrese un tipo de membresía válido (mensual / semestral / anual): ", 4, 25);
                        }
                    }
                    int precioMembresia = escogerInt("Ingrese el precio total de la membresía: ", 1000, 1000000);
                    Membresia membresiaNueva = new Membresia(tipoMensualidad, precioMembresia, LocalDate.now());
                    Socio socioNuevo = new Socio(nombreSocio, apellidoSocio, edadSocio, rutSocio, membresiaNueva);
                    listaSocios.add(socioNuevo);
                    System.out.println("Socio añadido exitosamente.");
                    break;
                    
                case 2: // remover socio
                    if (listaSocios.isEmpty()) {
                        System.out.println("No se han registrado socios.");
                        break;
                    }
                    int rutSocioEliminar = escogerInt("Ingrese el rut del socio que desea eliminar: ", 10000000, 99999999);
                    Socio socioEliminar = buscarSocioRut(rutSocioEliminar);
                    if (socioEliminar == null) {
                        System.out.println("No existe un socio con dicho rut. Operación cancelada.");
                    } else {
                        String confirmacionEliminar = escogerString("¿Desea eliminar el socio " + socioEliminar.getNombre() + " " + socioEliminar.getApellido() + "? Ingrese: S/N: ", 1, 2);
                        if (confirmacionEliminar.equalsIgnoreCase("S") || confirmacionEliminar.equalsIgnoreCase("Si") || confirmacionEliminar.equalsIgnoreCase("Sí")) {
                            this.listaSocios.remove(socioEliminar);
                            System.out.println("El socio se ha eliminado exitosamente.");   
                        } else {
                            System.out.println("Operación cancelada.");
                        }
                    }
                    break;
                
                case 3: // modificar membresía de un socio
                    if (listaSocios.isEmpty()) {
                        System.out.println("No se han registrado socios.");
                        break;
                    }
                    int rutSocioModificar = escogerInt("Ingrese el rut del socio cuya membresía desea modificar: ", 10000000, 99999999);
                    Socio socioModificacionMembresia = buscarSocioRut(rutSocioModificar);
                    if (socioModificacionMembresia == null) {
                        System.out.println("No se ha encontrado un socio con dicho rut. Operación cancelada."); break;
                    }
                    System.out.println("La membresía del socio " + socioModificacionMembresia.getNombre() + " " + socioModificacionMembresia.getApellido() + " es de tipo " + socioModificacionMembresia.getMembresia().getTipo() + " y su precio es de $" + socioModificacionMembresia.getMembresia().getPrecio());
                    int nuevoPrecio = escogerInt("¿A qué precio desea modificarla?: ", 1000, 1000000);
                    String confirmacionModificacion = escogerString("Confirme que desea modificar el precio desde $" + socioModificacionMembresia.getMembresia().getPrecio() + " a $" + nuevoPrecio + ". Ingrese: S/N: ", 1, 2);
                    if (confirmacionModificacion.equalsIgnoreCase("S") || confirmacionModificacion.equalsIgnoreCase("Si") || confirmacionModificacion.equalsIgnoreCase("Sí")) {
                        socioModificacionMembresia.getMembresia().setPrecio(nuevoPrecio);
                        System.out.println("Modificación realizada exitosamente.");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;
                    
                case 4: // listar socios
                    listarSocios();
                    break;
            }
        }
        
    }
    
    // ENTRENADORES
    
    public void listarEntrenadores() {
        if (listaEntrenadores.isEmpty()) {
            System.out.println("No se han registrado entrenadores.");
        } else {
            for (Entrenador entrenador : listaEntrenadores) {
                System.out.println(entrenador);
            }
        }
    }
    
    public Entrenador buscarEntrenadorRut(int rut) {
        for (Entrenador entrenador : listaEntrenadores) {
            if (rut == entrenador.getRut()) {
                return entrenador;
            }
        }
        return null;
    }
    
    public void agregarEntrenador(Entrenador entrenador) {
        this.listaEntrenadores.add(entrenador);
    }
    
    public void imprimirMenuEntrenadores() {
        System.out.println("");
        System.out.println("---Menú Entrenadores---");
        System.out.println("1.- Agregar entrenador");
        System.out.println("2.- Remover entrenador");
        System.out.println("3.- Asignar socio a un entrenador");
        System.out.println("4.- Remover socio a un entrenador");
        System.out.println("5.- Listar socios de un entrenador");
        System.out.println("6.- Listar entrenadores y sus socios asignados");
        System.out.println("0.- Volver al menú principal");
    }
    
    public void flujoMenuEntrenadores() {
        while (true) {
            imprimirMenuEntrenadores();
            int opcionME = escogerInt("Escoja una opción: ", 0, 6);
            
            switch (opcionME) {
                case 0: // volver al menú principal
                    return;
                    
                case 1: // agregar entrenador
                    String nombreEntrenador = escogerString("Ingrese el nombre del nuevo entrenador: ", 2, 20);
                    String apellidoEntrenador = escogerString("Ingrese el apellido del nuevo entrenador: ", 2, 20);
                    int rutEntrenador = escogerInt("Ingrese el rut del nuevo entrenador: ", 10000000, 99999999);
                    String especialidadEntrenador = escogerString("Ingrese la especialidad del nuevo entrenador: ", 5, 25);
                    if (buscarEntrenadorRut(rutEntrenador) != null){
                        System.out.println("Ya existe un entrenador con ese rut. Operación cancelada.");
                        break;
                    }
                    Entrenador entrenadorNuevo = new Entrenador(rutEntrenador, nombreEntrenador, apellidoEntrenador, especialidadEntrenador);
                    listaEntrenadores.add(entrenadorNuevo);
                    System.out.println("Entrenador añadido exitosamente.");
                    break;
                    
                case 2: // remover entrenador
                    if (listaEntrenadores.isEmpty()) {
                        System.out.println("No se han registrado entrenadores.");
                        break;
                    }
                    int rutEntrenadorEliminar = escogerInt("Ingrese el rut del entrenador que desea eliminar: ", 10000000, 99999999);
                    Entrenador entrenadorEliminar = buscarEntrenadorRut(rutEntrenadorEliminar);
                    if (entrenadorEliminar == null) {
                        System.out.println("No existe un entrenador con dicho rut. Operación cancelada.");
                    } else {
                        String confirmacionEliminar = escogerString("¿Desea eliminar el entrenador " + entrenadorEliminar.getNombre() + " " + entrenadorEliminar.getApellido() + "? Ingrese: S/N: ", 1, 2);
                        if (confirmacionEliminar.equalsIgnoreCase("S") || confirmacionEliminar.equalsIgnoreCase("Si") || confirmacionEliminar.equalsIgnoreCase("Sí")) {
                            this.listaEntrenadores.remove(entrenadorEliminar);
                            System.out.println("El entrenador se ha eliminado exitosamente.");   
                        } else {
                            System.out.println("Operación cancelada.");
                        }
                    }
                    break;
                    
                case 3: // asignar socio a un entrenador
                    if (listaSocios.isEmpty() || listaEntrenadores.isEmpty()) {
                        System.out.println("Primero debe contar con entrenadores y socios registrados. Operación cancelada.");
                        break;
                    }
                    int rutEntrenadorAsignar = escogerInt("Ingrese el rut del entrenador al que desea asignarle un socio: ", 10000000, 99999999);
                    Entrenador entrenadorAsignar = buscarEntrenadorRut(rutEntrenadorAsignar);
                    if (entrenadorAsignar == null) {
                        System.out.println("No existe un entrenador con dicho rut. Operación cancelada.");
                        break;
                    }   
                    int rutSocioAsignar = escogerInt("Ingrese el rut del socio que desea asignarle al entrenador: ", 10000000, 99999999);
                    Socio socioAsignar = buscarSocioRut(rutSocioAsignar);
                    if (socioAsignar == null) {
                        System.out.println("No existe un socio con dicho rut. Operación cancelada.");
                        break;
                    }
                    String confirmacionAsignacion = escogerString("¿Desea asignar el socio " + socioAsignar.getNombre() + " " + socioAsignar.getApellido() + " al entrenador " + entrenadorAsignar.getNombre() + " " + entrenadorAsignar.getApellido() + "? Ingrese: S/N: ", 1, 2);
                    if (confirmacionAsignacion.equalsIgnoreCase("S") || confirmacionAsignacion.equalsIgnoreCase("Si") || confirmacionAsignacion.equalsIgnoreCase("Sí")) {
                        entrenadorAsignar.agregarSocio(socioAsignar);
                        System.out.println("El socio se ha asignado exitosamente.");   
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;
                    
                case 4: // remover socio a un entrenador
                    if (listaSocios.isEmpty() || listaEntrenadores.isEmpty()) {
                        System.out.println("Primero debe contar con entrenadores y socios registrados. Operación cancelada.");
                        break;
                    }
                    int rutEntrenadorRemover = escogerInt("Ingrese el rut del entrenador al que desea removerle un socio: ", 10000000, 99999999);
                    Entrenador entrenadorRemover = buscarEntrenadorRut(rutEntrenadorRemover);
                    if (entrenadorRemover == null) {
                        System.out.println("No existe un entrenador con dicho rut. Operación cancelada.");
                        break;
                    }
                    System.out.println("El entrenador " + entrenadorRemover.getNombre() + " " + entrenadorRemover.getApellido() + " tiene los siguientes socios registrados: ");
                    entrenadorRemover.listarSocios();  
                    int rutSocioRemover = escogerInt("Ingrese el rut del socio que desea remover del entrenador: ", 10000000, 99999999);
                    Socio socioRemover = buscarSocioRutEntrenador(rutSocioRemover, entrenadorRemover);
                    if (socioRemover == null) {
                        System.out.println("El entrenador no tiene ningún socio con el rut ingresado. Operación cancelada.");
                        break;
                    }
                    String confirmacionEliminacion = escogerString("¿Desea remover el socio " + socioRemover.getNombre() + " " + socioRemover.getApellido() + " al entrenador " + entrenadorRemover.getNombre() + " " + entrenadorRemover.getApellido() + "? Ingrese: S/N: ", 1, 2);
                    if (confirmacionEliminacion.equalsIgnoreCase("S") || confirmacionEliminacion.equalsIgnoreCase("Si") || confirmacionEliminacion.equalsIgnoreCase("Sí")) {
                        entrenadorRemover.removerSocio(socioRemover);
                        System.out.println("El socio se ha eliminado exitosamente.");   
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;
                    
                    
                case 5: // listar socios de un entrenador
                    if (listaSocios.isEmpty() || listaEntrenadores.isEmpty()) {
                        System.out.println("Primero debe contar con entrenadores y socios registrados. Operación cancelada.");
                        break;
                    }
                  int rutEntrenadorListar = escogerInt("Ingrese el rut del entrenador cuyos socios desea listar: ", 10000000, 99999999);
                    Entrenador entrenadorListar = buscarEntrenadorRut(rutEntrenadorListar);
                    if (entrenadorListar == null) {
                        System.out.println("No existe un entrenador con dicho rut. Operación cancelada.");
                        break;
                    }
                    if (entrenadorListar.getSociosAsignados().isEmpty()) {
                        System.out.println("El entrenador " + entrenadorListar.getNombre() + " " + entrenadorListar.getApellido() + " no tiene socios registrados.");
                    } else {
                        System.out.println("El entrenador " + entrenadorListar.getNombre() + " " + entrenadorListar.getApellido() + " tiene los siguientes socios registrados: ");
                        entrenadorListar.listarSocios();  
                    }
                    break;

                    
                case 6: // listar entrenadores y sus socios asignados
                    if (listaEntrenadores.isEmpty()) {
                        System.out.println("Primero debe contar con entrenadores registrados. Operación cancelada.");
                        break;
                    }
                    listarEntrenadores();
                    break;
                    
            }
        }
    }
    
    
    // REPORTES
    
    public void imprimirMenuReportes() {
        System.out.println("");
        System.out.println("---Menú Reportes---");
        System.out.println("1.- Listar equipos");
        System.out.println("2.- Listar socios");
        System.out.println("3.- Listar entrenadores");
        System.out.println("4.- Mostrar ganancias acumuladas");
        System.out.println("0.- Volver al menú principal");
    }
    
    public void listarEquipos() {
        if (listaEquipos.isEmpty()) {
            System.out.println("No se han agregado equipos.");
        } else {
            for (Equipo equipo : listaEquipos) {
                System.out.println(equipo);
            }
        }
    }
    
    public void flujoMenuReportes() {
        while (true) {
            imprimirMenuReportes();
            int opcionMR = escogerInt("Escoja una opción: ", 0, 5); // REVISAR MAX ACÁ
            
            switch(opcionMR) {
                case 0:
                    return;
                    
                case 1:
                    listarEquipos();
                    break;
                    
                case 2:
                    listarSocios();
                    break;
                    
                case 3:
                    listarEntrenadores();
                    break;
                    
                case 4:
                    int gananciasTotales = 0;
                    for (Socio socio : listaSocios) {
                        gananciasTotales += socio.getMembresia().getPrecio();
                    }
                    System.out.println("Las ganancias totales acumuladas corresponden a $" + gananciasTotales);
            }
        }
    }
       
}
