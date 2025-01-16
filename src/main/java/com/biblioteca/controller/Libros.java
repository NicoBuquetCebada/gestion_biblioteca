package com.biblioteca.controller;

import com.biblioteca.model.DAO;
import com.biblioteca.model.Libro;

import java.util.List;

public class Libros {

    public static Libro add (String isbn, String titulo, String autor) {
        DAO dao = new DAO(Libro.class, String.class);
        if (dao.selectById(isbn) != null)
            return null;
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        dao.insert(libro);
        return libro;
    }

    public static Libro delete (String isbn) {
        DAO dao = new DAO(Libro.class, String.class);
        if (dao.selectById(isbn) == null)
            return null;
        Libro libro = (Libro)dao.selectById(isbn);
        dao.delete(libro);
        return libro;
    }

    public static Libro update (String isbn, String titulo, String autor) {
        DAO dao = new DAO(Libro.class, String.class);
        if (dao.selectById(isbn) == null)
            return null;
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        dao.update(libro);
        return libro;
    }

    public static Libro select (String isbn) {
        DAO dao = new DAO(Libro.class, String.class);
        if (dao.selectById(isbn) == null)
            return null;
        Libro libro = (Libro)dao.selectById(isbn);
        return libro;
    }

    public static List<Libro> selectAll () {
        DAO dao = new DAO(Libro.class, Libro.class);
        return dao.selectAll();
    }
}
