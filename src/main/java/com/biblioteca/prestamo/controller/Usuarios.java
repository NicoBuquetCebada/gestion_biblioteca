package com.biblioteca.prestamo.controller;

import com.biblioteca.prestamo.model.DAO;
import com.biblioteca.prestamo.model.Usuario;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class Usuarios {
    public static DAO daoU = new DAO(Usuario.class, Integer.class);

    public static Integer checkLogin(String dni, String pass) {
        dni = dni.toUpperCase();
        Usuario usuario;
        try {
            usuario = daoU.selectUsuarioByDni(dni);
        } catch (NoResultException e) {
            return -1;
        }
        if (!usuario.getPassword().equals(pass))
            return -1;
        return usuario.getId();
    }

    public static Usuario getUsuario(Integer id) {
        return (Usuario) daoU.selectById(id);
    }

    public static void add() {

    }
}
