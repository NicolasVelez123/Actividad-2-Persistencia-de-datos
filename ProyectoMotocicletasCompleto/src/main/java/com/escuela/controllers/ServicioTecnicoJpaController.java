package com.escuela.controllers;

import com.escuela.entities.ServicioTecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;

public class ServicioTecnicoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ServicioTecnicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Este es el método 'create' que el Main necesita
    public void create(ServicioTecnico servicioTecnico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(servicioTecnico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}