package com.escuela.controllers;

import com.escuela.entities.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class ProveedorJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Guarda un nuevo proveedor en la base de datos.
     * Este es el método que te faltaba en el error de compilación.
     */
    public void create(Proveedor proveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Retorna la lista completa de proveedores.
     */
    public List<Proveedor> findProveedorEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Busca un proveedor específico por su ID.
     */
    public Proveedor findProveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }
}