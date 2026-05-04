package com.escuela.entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Entidad Motocicleta actualizada para incluir Proveedor y Tipo.
 */
@Entity
@Table(name = "tb_motocicleta")
public class Motocicleta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Integer idMoto;

    @Column(name = "marca_moto")
    private String marcaMoto;

    @Column(name = "modelo_moto")
    private String modeloMoto;

    @Column(name = "anio_moto")
    private Integer anioMoto;

    @Column(name = "precio_moto")
    private Double precioMoto;

    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    private TipoMotocicleta idTipo;

    @ManyToOne
    @JoinColumn(name = "id_prov", referencedColumnName = "id_prov")
    private Proveedor idProv;
 
    public Motocicleta() {
    }

    public Motocicleta(Integer idMoto, String marcaMoto, String modeloMoto, Integer anioMoto, Double precioMoto, TipoMotocicleta idTipo, Proveedor idProv) {
        this.idMoto = idMoto;
        this.marcaMoto = marcaMoto;
        this.modeloMoto = modeloMoto;
        this.anioMoto = anioMoto;
        this.precioMoto = precioMoto;
        this.idTipo = idTipo;
        this.idProv = idProv;
    }

    // --- GETTERS Y SETTERS ---

    public Integer getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Integer idMoto) {
        this.idMoto = idMoto;
    }

    public String getMarcaMoto() {
        return marcaMoto;
    }

    public void setMarcaMoto(String marcaMoto) {
        this.marcaMoto = marcaMoto;
    }

    public String getModeloMoto() {
        return modeloMoto;
    }

    public void setModeloMoto(String modeloMoto) {
        this.modeloMoto = modeloMoto;
    }

    public Integer getAnioMoto() {
        return anioMoto;
    }

    public void setAnioMoto(Integer anioMoto) {
        this.anioMoto = anioMoto;
    }

    public Double getPrecioMoto() {
        return precioMoto;
    }

    public void setPrecioMoto(Double precioMoto) {
        this.precioMoto = precioMoto;
    }

    public TipoMotocicleta getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoMotocicleta idTipo) {
        this.idTipo = idTipo;
    }

    public Proveedor getIdProv() {
        return idProv;
    }

    public void setIdProv(Proveedor idProv) {
        this.idProv = idProv;
    }

    @Override
    public String toString() {
        return "Moto: " + marcaMoto + " " + modeloMoto + " (" + anioMoto + ") - Proveedor: " + (idProv != null ? idProv.getNombreProv() : "Sin asignar");
    }
}