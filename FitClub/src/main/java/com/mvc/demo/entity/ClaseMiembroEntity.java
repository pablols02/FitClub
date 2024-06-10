package com.mvc.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLASE_MIEMBRO")
public class ClaseMiembroEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "ID_CLASE")
    @Id
    private ClaseEntity clase;

    @ManyToOne
    @JoinColumn(name = "ID_MIEMBRO")
    @Id
    private MiembroEntity miembro;

    public ClaseMiembroEntity() {
        super();
    }

    public ClaseMiembroEntity( ClaseEntity clase, MiembroEntity miembro) {
        super();
        this.clase = clase;
        this.miembro = miembro;
    }

    public ClaseEntity getClase() {
        return clase;
    }

    public void setClase(ClaseEntity clase) {
        this.clase = clase;
    }

    public MiembroEntity getMiembro() {
        return miembro;
    }

    public void setMiembro(MiembroEntity miembro) {
        this.miembro = miembro;
    }
}
