package com.biblioteca.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class DAO<T, ID> {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    Class<T> Class;
    Class<ID> IDClass;

    public DAO(Class<T> Class, Class<ID> IDClass) {
        this.Class = Class;
        this.IDClass = IDClass;
    }

    //select All
    public List<T> selectAll() {
        List<T> list = new ArrayList<>();
        list = em.createQuery("select c from "+ Class.getName() +" c").getResultList();
        return list;
    }

    //select
    public T selectById(ID id) {
        return em.find(Class, id);
    }

    //insert
    public void insert(T object) {
        tx.begin();
        em.persist(object);
        tx.commit();
    }

    //update
    public T update(T object) {
        tx.begin();
        object = em.merge(object);
        tx.commit();
        return object;
    }

    //delete
    public void delete(T object) {
        tx.begin();
        object = em.merge(object);
        em.remove(object);
        tx.commit();
    }

    //select usuario
    public Usuario selectUsuarioByDni(String dni) {
        String sql = "select u from Usuario u where u.dni = :dni";
        TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
        query.setParameter("dni", dni);
        return query.getSingleResult();
    }
}
