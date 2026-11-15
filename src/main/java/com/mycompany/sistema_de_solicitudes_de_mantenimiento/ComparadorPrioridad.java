/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_solicitudes_de_mantenimiento;

import java.util.Comparator;

public class ComparadorPrioridad implements Comparator<SolicitudMantenimiento>{
    @Override
    public int compare(SolicitudMantenimiento s1, SolicitudMantenimiento s2) {
        // Un número menor indica mayor prioridad (1 es más urgente que 4)
        return Integer.compare(s1.getNivelPrioridad(), s2.getNivelPrioridad());
    
    }
}
