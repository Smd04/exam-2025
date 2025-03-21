package org.example.exam.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.exam.Model.Magazine;

import java.util.List;

public class MagazineDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mypersistence");

    public void create(Magazine magazine) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(magazine);
        em.getTransaction().commit();
        em.close();
    }
    public void edit(Magazine magazine) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Magazine persistentMagazine = em.find(Magazine.class, magazine.getId());
        em.persist(magazine);
        em.getTransaction().commit();
        em.close();
    }
    public Magazine findMagazineById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Magazine.class, id);
    }
    public List<Magazine> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select m from Magazine m").getResultList();
    }
    public void destroy(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Magazine magazine = em.find(Magazine.class, id);
        em.remove(magazine);
        em.getTransaction().commit();
        em.close();
    }
}
