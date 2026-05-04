package com.escuela.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_proveedor")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prov")
    private Integer idProv;

    @Column(name = "nombre_prov")
    private String nombreProv;

    @Column(name = "contacto_prov")
    private String contactoProv;

    public Proveedor() {}

    // Getters y Setters
    public Integer getIdProv() { return idProv; }
    public void setIdProv(Integer idProv) { this.idProv = idProv; }

    public String getNombreProv() { return nombreProv; }
    public void setNombreProv(String nombreProv) { this.nombreProv = nombreProv; }

    public String getContactoProv() { return contactoProv; }
    public void setContactoProv(String contactoProv) { this.contactoProv = contactoProv; }
}