/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_solicitudes_de_mantenimiento;



import java.util.Objects;

public class Usuario {
    private String identificacion;
    private String nombre;
    private String departamento;

    public Usuario(String identificacion, String nombre, String departamento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(identificacion, usuario.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }

    @Override
    public String toString() {
        return "Usuario [ID=" + identificacion + ", Nombre=" + nombre + ", Depto=" + departamento + "]";
    }
    
}
