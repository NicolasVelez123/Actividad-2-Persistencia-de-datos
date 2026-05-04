package com.escuela.controllers;

import com.escuela.entities.TipoMotocicleta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class TipoMotocicletaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public TipoMotocicletaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Este es el método que tu Main.java está buscando en la línea 72.
     * Asegúrate de que el nombre sea EXACTAMENTE este.
     */
    public List<TipoMotocicleta> findTipoMotocicletaEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoMotocicleta.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Método para buscar un tipo por su ID (usado en la selección).
     */
    public TipoMotocicleta findTipoMotocicleta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoMotocicleta.class, id);
        } finally {
            em.close();
        }
    }
}