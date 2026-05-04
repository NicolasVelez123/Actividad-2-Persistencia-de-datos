package com.escuela.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_servicio_tecnico")
public class ServicioTecnico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "detalle_servicio") // Coincide con tu diagrama
    private String detalleServicio;

    @Column(name = "fecha_servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;

    @Column(name = "costo_ser") // Este es el precio
    private Double costoSer;

    @ManyToOne
    @JoinColumn(name = "id_moto", referencedColumnName = "id_moto")
    private Motocicleta idMoto;

    public ServicioTecnico() {}

    // Getters y Setters
    public Integer getIdServicio() { return idServicio; }
    public void setIdServicio(Integer idServicio) { this.idServicio = idServicio; }

    public String getDetalleServicio() { return detalleServicio; }
    public void setDetalleServicio(String detalleServicio) { this.detalleServicio = detalleServicio; }

    public Date getFechaServicio() { return fechaServicio; }
    public void setFechaServicio(Date fechaServicio) { this.fechaServicio = fechaServicio; }

    public Double getCostoSer() { return costoSer; }
    public void setCostoSer(Double costoSer) { this.costoSer = costoSer; }

    public Motocicleta getIdMoto() { return idMoto; }
    public void setIdMoto(Motocicleta idMoto) { this.idMoto = idMoto; }
}