package org.example.exam.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mypersistence");

    public void create(UserDAO user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(UserDAO user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }



    public void update(UserDAO user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public UserDAO findById(int id) {
        EntityManager em = emf.createEntityManager();
        UserDAO user = em.find(UserDAO.class, id);
        em.close();
        return user;
    }
}
