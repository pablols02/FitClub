package com.mvc.demo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "MIEMBRO")
public class MiembroEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMiembro")
    @SequenceGenerator(name = "seqMiembro", allocationSize = 1, sequenceName = "SEQ_MIEMBRO")
    @Column(name = "ID_MIEMBRO")
    private Integer idMiembro;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;
    
    @ManyToMany(mappedBy = "lstMiembros")
    private List<ClaseEntity> lstClases;

    public MiembroEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MiembroEntity(Integer idMiembro, UsuarioEntity usuario, List<ClaseEntity> lstClases) {
		super();
		this.idMiembro = idMiembro;
		this.usuario = usuario;
		this.lstClases = lstClases;
	}

	public Integer getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(Integer idMiembro) {
		this.idMiembro = idMiembro;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<ClaseEntity> getLstClases() {
		return lstClases;
	}

	public void setLstClases(List<ClaseEntity> lstClases) {
		this.lstClases = lstClases;
	}

}