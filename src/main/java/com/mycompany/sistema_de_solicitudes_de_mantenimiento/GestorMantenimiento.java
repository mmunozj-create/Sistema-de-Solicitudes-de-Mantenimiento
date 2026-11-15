/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_solicitudes_de_mantenimiento;

import java.util.*;

public class GestorMantenimiento {
    // 1. Colección principal de objetos (ArrayList)
    private List<SolicitudMantenimiento> listaSolicitudes;

    // 2. Control de datos únicos mediante Set (HashSet para tipos de daño)
    private Set<String> tiposDanoUnicos;

    // 3. Búsqueda rápida mediante Map (HashMap por código)
    private Map<String, SolicitudMantenimiento> mapaSolicitudes;

    // 4. Información ordenada mediante TreeSet (ordenado por código)
    private TreeSet<SolicitudMantenimiento> setOrdenadoSolicitudes;

    // 5. Procesamiento por prioridad mediante PriorityQueue
    private PriorityQueue<SolicitudMantenimiento> colaPrioritaria;

    public GestorMantenimiento() {
        this.listaSolicitudes = new ArrayList<>();
        this.tiposDanoUnicos = new HashSet<>();
        this.mapaSolicitudes = new HashMap<>();
        this.setOrdenadoSolicitudes = new TreeSet<>();
        this.colaPrioritaria = new PriorityQueue<>(new ComparadorPrioridad());
        
        cargarDatosPrueba();
    }

    public void registrarSolicitud(String codigo, String tipoDano, Equipo equipo, Usuario usuario, int prioridad, String estado) {
        if (mapaSolicitudes.containsKey(codigo)) {
            System.out.println("Error: Ya existe una solicitud con el código " + codigo);
            return;
        }

        SolicitudMantenimiento nueva = new SolicitudMantenimiento(codigo, tipoDano, equipo, usuario, prioridad, estado);

        // Se agrega a todas las estructuras manteniendo la consistencia
        listaSolicitudes.add(nueva);
        tiposDanoUnicos.add(tipoDano);
        mapaSolicitudes.put(codigo, nueva);
        setOrdenadoSolicitudes.add(nueva);
        colaPrioritaria.add(nueva);

        System.out.println("Solicitud registrada y sincronizada correctamente.");
    }

    public void consultarTodas() {
        if (listaSolicitudes.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
            return;
        }
        System.out.println("\n--- LISTADO GENERAL DE SOLICITUDES (ArrayList) ---");
        for (SolicitudMantenimiento s : listaSolicitudes) {
            System.out.println(s);
        }
    }

    public SolicitudMantenimiento buscarPorCodigo(String codigo) {
        // Búsqueda instantánea O(1) usando Map
        return mapaSolicitudes.get(codigo);
    }

    public void consultarTiposDanoUnicos() {
        System.out.println("\n--- TIPOS DE DAÑO ÚNICOS (HashSet) ---");
        for (String tipo : tiposDanoUnicos) {
            System.out.println("- " + tipo);
        }
    }

    public void mostrarSolicitudesOrdenadas() {
        System.out.println("\n--- SOLICITUDES ORDENADAS POR CÓDIGO (TreeSet) ---");
        for (SolicitudMantenimiento s : setOrdenadoSolicitudes) {
            System.out.println(s);
        }
    }

    public void consultarProximaPrioritaria() {
        SolicitudMantenimiento proxima = colaPrioritaria.peek();
        if (proxima != null) {
            System.out.println("\n Próxima solicitud a atender (PriorityQueue): " + proxima);
        } else {
            System.out.println("La cola prioritaria está vacía.");
        }
    }

    public void atenderSiguientePrioritaria() {
        SolicitudMantenimiento atendida = colaPrioritaria.poll();
        if (atendida != null) {
            atendida.setEstado("ATENDIDA");
            System.out.println("Solicitud atendida con éxito: " + atendida);
        } else {
            System.out.println("No hay solicitudes pendientes.");
        }
    }

    public void eliminarSolicitud(String codigo) {
        SolicitudMantenimiento s = mapaSolicitudes.get(codigo);
        if (s == null) {
            System.out.println("No se encontró la solicitud con código: " + codigo);
            return;
        }

        // Eliminación sincronizada en todas las colecciones
        listaSolicitudes.remove(s);
        mapaSolicitudes.remove(codigo);
        setOrdenadoSolicitudes.remove(s);
        colaPrioritaria.remove(s);

        System.out.println("Solicitud eliminada de forma sincronizada en todo el sistema.");
    }

    private void cargarDatosPrueba() {
        // Carga de los 15 objetos mínimos requeridos por la guía
        Equipo eq1 = new Equipo("EQ-01", "Servidor Principal", "Sala de Redes");
        Equipo eq2 = new Equipo("EQ-02", "Impresora Láser", "Oficina 102");
        Equipo eq3 = new Equipo("EQ-03", "Aire Acondicionado", "Laboratorio");

        Usuario us1 = new Usuario("US-100", "Carlos Pérez", "Sistemas");
        Usuario us2 = new Usuario("US-200", "Ana Gómez", "Administración");

        registrarSolicitud("SOL-005", "Falla de red", eq1, us1, 1, "PENDIENTE");
        registrarSolicitud("SOL-001", "Atasco de papel", eq2, us2, 3, "PENDIENTE");
        registrarSolicitud("SOL-010", "Fuga de gas", eq3, us1, 2, "PENDIENTE");
        registrarSolicitud("SOL-003", "Sobrecalentamiento", eq1, us2, 1, "PENDIENTE");
        registrarSolicitud("SOL-002", "Sin tóner", eq2, us1, 4, "PENDIENTE");
        registrarSolicitud("SOL-008", "Puerto LAN dañado", eq1, us2, 2, "PENDIENTE");
        registrarSolicitud("SOL-004", "Ruido extraño", eq3, us1, 3, "PENDIENTE");
        registrarSolicitud("SOL-007", "Actualización firmware", eq1, us2, 4, "PENDIENTE");
        registrarSolicitud("SOL-006", "Display roto", eq2, us1, 2, "PENDIENTE");
        registrarSolicitud("SOL-009", "Cortocircuito", eq3, us2, 1, "PENDIENTE");
        registrarSolicitud("SOL-011", "Error de encendido", eq1, us1, 2, "PENDIENTE");
        registrarSolicitud("SOL-012", "Limpieza filtros", eq3, us2, 4, "PENDIENTE");
        registrarSolicitud("SOL-013", "Bandeja rota", eq2, us1, 3, "PENDIENTE");
        registrarSolicitud("SOL-014", "Configuración IP", eq1, us2, 3, "PENDIENTE");
        registrarSolicitud("SOL-015", "Cambio cables", eq1, us1, 2, "PENDIENTE");
    }
    
}
