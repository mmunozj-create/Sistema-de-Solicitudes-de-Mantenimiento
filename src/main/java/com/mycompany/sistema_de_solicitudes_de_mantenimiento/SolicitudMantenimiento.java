/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_solicitudes_de_mantenimiento;

import java.util.Objects;

public class SolicitudMantenimiento implements Comparable<SolicitudMantenimiento>{
    private String codigo;
    private String tipoDano;
    private Equipo equipo;
    private Usuario usuario;
    private int nivelPrioridad; // 1: URGENTE, 2: ALTA, 3: MEDIA, 4: BAJA
    private String estado; // PENDIENTE, ATENDIDA

    public SolicitudMantenimiento(String codigo, String tipoDano, Equipo equipo, Usuario usuario, int nivelPrioridad, String estado) {
        this.codigo = codigo;
        this.tipoDano = tipoDano;
        this.equipo = equipo;
        this.usuario = usuario;
        this.nivelPrioridad = nivelPrioridad;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTipoDano() { return tipoDano; }
    public void setTipoDano(String tipoDano) { this.tipoDano = tipoDano; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public int getNivelPrioridad() { return nivelPrioridad; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public int compareTo(SolicitudMantenimiento o) {
        // Orden natural basado en el código de la solicitud (para el TreeSet)
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudMantenimiento that = (SolicitudMantenimiento) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Solicitud [Código=" + codigo + ", Daño=" + tipoDano + ", Prioridad=" + nivelPrioridad + 
               ", Estado=" + estado + ", Equipo=" + equipo.getNombre() + "]";
    }
}
