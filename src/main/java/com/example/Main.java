package com.example;

public class Main {

    public static void main(String[] args) {

        // 1. Creamos autores con diferentes constructores
        Autor autor1 = new Autor(
                "A001", "Gabriel García Márquez", "Colombiana", 1927
        );

        Autor autor2 = new Autor("A002", "Jorge Luis Borges");

        // 2. Creamos libros con diferentes constructores
        Libro libro1 = new Libro(
                "978-0307474728", "Cien años de soledad",
                autor1, 1967, 45000.0, 12
        );

        Libro libro2 = new Libro(
                "978-8497592208", "Ficciones", autor2
        );

        // 3. Creamos usuarios con diferentes constructores
        Usuario usuario1 = new Usuario(
                "U001", "Ana Pérez", "ana.perez@correo.com", 2
        );

        Usuario usuario2 = new Usuario("U002", "Carlos Gómez");

        // 4. Probamos getters
        System.out.println("Título del libro: " + libro1.getTitulo());
        System.out.println("Nombre del usuario: " + usuario1.getNombre());

        // 5. Probamos setters
        libro2.setPrecio(38000.0);
        libro2.setStock(5);
        usuario2.setCorreoElectronico("carlos.gomez@correo.com");
        usuario2.setLibrosPrestados(1);

        // 6. Mostramos los objetos mediante toString()
        System.out.println("\n--- AUTORES ---");
        System.out.println(autor1);
        System.out.println(autor2);

        System.out.println("\n--- LIBROS ---");
        System.out.println(libro1);
        System.out.println(libro2);

        System.out.println("\n--- USUARIOS ---");
        System.out.println(usuario1);
        System.out.println(usuario2);

        // 7. Comprobamos el manejo de errores
        try {
            libro1.setPrecio(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidación correcta: " + e.getMessage());
        }
    }
}
