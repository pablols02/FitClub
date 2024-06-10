package com.mvc.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "MONITOR")
public class MonitorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMonitor")
    @SequenceGenerator(name = "seqMonitor", allocationSize = 1, sequenceName = "SEQ_MONITOR")
    @Column(name = "ID_MONITOR")
    private Integer idMonitor;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    public MonitorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitorEntity(Integer idMonitor, UsuarioEntity usuario) {
        this.idMonitor = idMonitor;
        this.usuario = usuario;
    }

    // Getters and setters
    public Integer getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(Integer idMonitor) {
        this.idMonitor = idMonitor;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}