package com.escuela.controllers;
 
import com.escuela.entities.Motocicleta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
 
public class MotocicletaJpaController {
    
    private EntityManagerFactory emf;
    
    public MotocicletaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    // CREATE
    public void create(Motocicleta m) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }
    
    // READ - Obtener todas
    public List<Motocicleta> findMotocicletaEntities() {
        EntityManager em = getEntityManager();
        return em.createQuery(
                "SELECT m FROM Motocicleta m",
                Motocicleta.class
        ).getResultList();
    }
    
    // READ - Obtener por ID
    public Motocicleta findMotocicleta(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Motocicleta.class, id);
    }
    
    // UPDATE
    public void edit(Motocicleta m) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
        em.close();
    }
    
    // DELETE
    public void destroy(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Motocicleta m = em.find(Motocicleta.class, id);
        if (m != null) {
            em.remove(m);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    // COUNT
    public int getMotocicletaCount() {
        EntityManager em = getEntityManager();
        return ((Long) em.createQuery(
                "SELECT COUNT(m) FROM Motocicleta m"
        ).getSingleResult()).intValue();
    }
}