package org.example.exam.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.exam.Model.Document;

import java.util.List;

public class DocumenDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mypersistence");

    public void create(Document document) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
        em.close();
    }
    public void edit(Document document) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(document);
        em.getTransaction().commit();
        em.close();
    }
    public Document findDocument(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Document.class, id);
    }
    public List<Document> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select d from Document d").getResultList();
    }
    public void destroy(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Document document = em.find(Document.class, id);
        em.remove(document);
    }
}
