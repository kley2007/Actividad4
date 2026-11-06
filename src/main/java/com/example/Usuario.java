package com.example;

public class Usuario {

    private String idUsuario;
    private String nombre;
    private String correoElectronico;
    private int librosPrestados;

    // 1. Constructor por defecto
    public Usuario() {
    }

    // 2. Constructor parametrizado completo
    public Usuario(String idUsuario, String nombre,
                   String correoElectronico, int librosPrestados) {
        setIdUsuario(idUsuario);
        setNombre(nombre);
        setCorreoElectronico(correoElectronico);
        setLibrosPrestados(librosPrestados);
    }

    // 3. Constructor sobrecargado: ID y nombre
    public Usuario(String idUsuario, String nombre) {
        this(idUsuario, nombre, "usuario@ejemplo.com", 0);
    }

    // 4. Segundo constructor sobrecargado: incluye correo
    public Usuario(String idUsuario, String nombre, String correoElectronico) {
        this(idUsuario, nombre, correoElectronico, 0);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = validarTexto(idUsuario, "El ID del usuario");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre");
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        String correo = validarTexto(correoElectronico, "El correo electrónico");
        if (!correo.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
        this.correoElectronico = correo;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        if (librosPrestados < 0) {
            throw new IllegalArgumentException("La cantidad de libros prestados no puede ser negativa.");
        }
        this.librosPrestados = librosPrestados;
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}
