package com.biblioteca.controller;

import com.biblioteca.model.DAO;
import com.biblioteca.model.Ejemplar;
import com.biblioteca.model.Estado;
import com.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;

public class Ejemplares {
    private static DAO daoE = new DAO(Ejemplar.class, Integer.class);
    private static DAO daoL = new DAO(Libro.class, String.class);

    public static boolean add(String isbn, String estado) {
        Libro libro = (Libro) daoL.selectById(isbn);
        if (libro == null)
            return false;
        estado = estado.toUpperCase();
        Estado enumEstado = Estado.DISPONIBLE;
        try {
            enumEstado = Estado.valueOf(estado);
        } catch (IllegalArgumentException e) {}
        Ejemplar ejemplar = new Ejemplar();
        //ejemplar.setId(id); AUTO_INCREMENT
        ejemplar.setIsbn(libro);
        ejemplar.setEstado(enumEstado);
        daoE.insert(ejemplar);
        return true;
    }
    public static List<Ejemplar> showStock() {
        List<Ejemplar> ejemplares = daoE.selectAll();
        List<Ejemplar> stock = new ArrayList<>();
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.getEstado().equals(Estado.DISPONIBLE))
                stock.add(ejemplar);
        }
        return stock;
    }
}
