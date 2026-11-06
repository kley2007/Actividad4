package com.example;

import java.time.Year;

public class Libro {

    private String isbn;
    private String titulo;
    private Autor autor;
    private int anioPublicacion;
    private double precio;
    private int stock;

    // 1. Constructor por defecto
    public Libro() {
    }

    // 2. Constructor parametrizado completo
    public Libro(String isbn, String titulo, Autor autor,
                 int anioPublicacion, double precio, int stock) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
        setAnioPublicacion(anioPublicacion);
        setPrecio(precio);
        setStock(stock);
    }

    // 3. Constructor sobrecargado: ISBN, título y autor
    public Libro(String isbn, String titulo, Autor autor) {
        this(isbn, titulo, autor, 0, 0.0, 0);
    }

    // 4. Segundo constructor sobrecargado: incluye año
    public Libro(String isbn, String titulo, Autor autor, int anioPublicacion) {
        this(isbn, titulo, autor, anioPublicacion, 0.0, 0);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = validarTexto(isbn, "El ISBN");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = validarTexto(titulo, "El título");
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo.");
        }
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion < 0 || anioPublicacion > Year.now().getValue()) {
            throw new IllegalArgumentException("El año de publicación no es válido.");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo ni inválido.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor=" + (autor == null ? "Sin asignar" : autor.getNombre()) +
                ", anioPublicacion=" + anioPublicacion +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
