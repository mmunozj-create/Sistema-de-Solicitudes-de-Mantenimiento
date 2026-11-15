/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.sistema_de_solicitudes_de_mantenimiento;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorMantenimiento gestor = new GestorMantenimiento();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA DE SOLICITUDES DE MANTENIMIENTO    ");
            System.out.println("==============================================");
            System.out.println("1. Registrar nueva solicitud");
            System.out.println("2. Consultar todas las solicitudes (ArrayList)");
            System.out.println("3. Buscar solicitud por código (HashMap)");
            System.out.println("4. Consultar tipos de daño únicos (HashSet)");
            System.out.println("5. Mostrar solicitudes ordenadas (TreeSet)");
            System.out.println("6. Consultar próxima solicitud prioritaria");
            System.out.println("7. Atender siguiente solicitud prioritaria");
            System.out.println("8. Eliminar solicitud (Consistencia)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Código de solicitud (ej. SOL-100): ");
                    String cod = scanner.nextLine();
                    System.out.print("Tipo de daño: ");
                    String dano = scanner.nextLine();
                    System.out.print("Código de equipo: ");
                    String codEq = scanner.nextLine();
                    System.out.print("Nombre de equipo: ");
                    String nomEq = scanner.nextLine();
                    System.out.print("ID de usuario: ");
                    String idUs = scanner.nextLine();
                    System.out.print("Nombre de usuario: ");
                    String nomUs = scanner.nextLine();
                    System.out.print("Prioridad (1=Urgente, 2=Alta, 3=Media, 4=Baja): ");
                    int prio = Integer.parseInt(scanner.nextLine());

                    Equipo eq = new Equipo(codEq, nomEq, "Área General");
                    Usuario us = new Usuario(idUs, nomUs, "Departamento General");

                    gestor.registrarSolicitud(cod, dano, eq, us, prio, "PENDIENTE");
                    break;

                case 2:
                    gestor.consultarTodas();
                    break;

                case 3:
                    System.out.print("Ingrese el código a buscar: ");
                    String busqueda = scanner.nextLine();
                    SolicitudMantenimiento encontrada = gestor.buscarPorCodigo(busqueda);
                    if (encontrada != null) {
                        System.out.println("Encontrada: " + encontrada);
                    } else {
                        System.out.println("No existe solicitud con ese código.");
                    }
                    break;

                case 4:
                    gestor.consultarTiposDanoUnicos();
                    break;

                case 5:
                    gestor.mostrarSolicitudesOrdenadas();
                    break;

                case 6:
                    gestor.consultarProximaPrioritaria();
                    break;

                case 7:
                    gestor.atenderSiguientePrioritaria();
                    break;

                case 8:
                    System.out.print("Ingrese el código de la solicitud a eliminar: ");
                    String codEliminar = scanner.nextLine();
                    gestor.eliminarSolicitud(codEliminar);
                    break;

                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
    }
    
