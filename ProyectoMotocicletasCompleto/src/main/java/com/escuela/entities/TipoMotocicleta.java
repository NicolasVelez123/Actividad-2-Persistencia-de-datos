package com.escuela.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_motocicleta")
public class TipoMotocicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "descripcion_tipo")
    private String descripcionTipo;

    public Integer getIdTipo() {
        return idTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}