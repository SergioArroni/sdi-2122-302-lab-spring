package com.example.sdi212202spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;
    private String Dni;
    private String Nombre;
    private String Apellidos;
    private String Categoría;

    public Professor() {
    }

    public Professor(Long id, String Dni, String Nombre, String Apellidos, String Categoría) {
        this.id = id;
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Categoría = Categoría;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return Dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getCategoría() {
        return Categoría;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public void setCategoría(String categoría) {
        Categoría = categoría;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", Dni='" + Dni + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Categoría='" + Categoría + '\'' +
                '}';
    }
}
