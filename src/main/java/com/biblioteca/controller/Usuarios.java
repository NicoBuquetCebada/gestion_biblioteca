package com.biblioteca.controller;

import com.biblioteca.model.DAO;
import com.biblioteca.model.Usuario;
import jakarta.persistence.NoResultException;

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
