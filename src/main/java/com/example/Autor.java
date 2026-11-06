package com.example;

import java.time.Year;

public class Autor {

    private String idAutor;
    private String nombre;
    private String nacionalidad;
    private int anioNacimiento;

    // 1. Constructor por defecto
    public Autor() {
    }

    // 2. Constructor parametrizado completo
    public Autor(String idAutor, String nombre, String nacionalidad, int anioNacimiento) {
        setIdAutor(idAutor);
        setNombre(nombre);
        setNacionalidad(nacionalidad);
        setAnioNacimiento(anioNacimiento);
    }

    // 3. Constructor sobrecargado
    public Autor(String idAutor, String nombre) {
        this(idAutor, nombre, "No especificada", 0);
    }

    // 4. Segundo constructor sobrecargado
    public Autor(String idAutor, String nombre, String nacionalidad) {
        this(idAutor, nombre, nacionalidad, 0);
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = validarTexto(idAutor, "El ID del autor");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre");
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = validarTexto(nacionalidad, "La nacionalidad");
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        if (anioNacimiento < 0 || anioNacimiento > Year.now().getValue()) {
            throw new IllegalArgumentException("El año de nacimiento no es válido.");
        }
        this.anioNacimiento = anioNacimiento;
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor='" + idAutor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                '}';
    }
}
