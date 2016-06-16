package com.jorge.springmvc.model;
// Generated 18/03/2016 11:50:18 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HistorialAbono generated by hbm2java
 */
@Entity
@Table(name="historial_abono"
    ,catalog="jpro"
)
public class HistorialAbono  implements java.io.Serializable {


     private int idHistorialAbono;
     private Abono abono;
     private Cultivo cultivo;
     private String descripcion;
     private Integer canidad;
     private Date fechaAplicaciom;
   
     @Id 

    
    @Column(name="id_historial_abono", unique=true, nullable=false)
    public int getIdHistorialAbono() {
        return this.idHistorialAbono;
    }
    
    public void setIdHistorialAbono(int idHistorialAbono) {
        this.idHistorialAbono = idHistorialAbono;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="abono_id_abono", nullable=false)
    public Abono getAbono() {
        return this.abono;
    }
    
    public void setAbono(Abono abono) {
        this.abono = abono;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cultivo_id_cultivo", nullable=false)
    public Cultivo getCultivo() {
        return this.cultivo;
    }
    
    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    
    @Column(name="descripcion", length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="canidad")
    public Integer getCanidad() {
        return this.canidad;
    }
    
    public void setCanidad(Integer canidad) {
        this.canidad = canidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_aplicaciom", length=19)
    public Date getFechaAplicaciom() {
        return this.fechaAplicaciom;
    }
    
    public void setFechaAplicaciom(Date fechaAplicaciom) {
        this.fechaAplicaciom = fechaAplicaciom;
    }




}


