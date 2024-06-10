package com.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CLASE")
public class ClaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClase")
    @SequenceGenerator(name = "seqClase", allocationSize = 1, sequenceName = "SEQ_CLASE")
    @Column(name = "ID_CLASE")
    private Integer idClase;

    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private MonitorEntity monitor;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "SALA")
    private String sala;

    @Column(name = "DIA")
    private String dia;

    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;

    @Column(name = "DURACION")
    private Integer duracion;

    @Column(name = "LIMITE_MIEMBROS")
    private Integer limiteMiembros;

    @ManyToMany
    @JoinTable(name = "CLASE_MIEMBRO",
            joinColumns = @JoinColumn(name = "ID_CLASE"),
            inverseJoinColumns = @JoinColumn(name = "ID_MIEMBRO"))
    private List<MiembroEntity> lstMiembros;

	public ClaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaseEntity(Integer idClase, MonitorEntity monitor, String nombre, String descripcion, String sala,
			String dia, Date hora, Integer duracion, Integer limiteMiembros, List<MiembroEntity> lstMiembros) {
		super();
		this.idClase = idClase;
		this.monitor = monitor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.sala = sala;
		this.dia = dia;
		this.hora = hora;
		this.duracion = duracion;
		this.limiteMiembros = limiteMiembros;
		this.lstMiembros = lstMiembros;
	}

	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public MonitorEntity getMonitor() {
		return monitor;
	}

	public void setMonitor(MonitorEntity monitor) {
		this.monitor = monitor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getLimiteMiembros() {
		return limiteMiembros;
	}

	public void setLimiteMiembros(Integer limiteMiembros) {
		this.limiteMiembros = limiteMiembros;
	}

	public List<MiembroEntity> getLstMiembros() {
		return lstMiembros;
	}

	public void setLstMiembros(List<MiembroEntity> lstMiembros) {
		this.lstMiembros = lstMiembros;
	}
}
