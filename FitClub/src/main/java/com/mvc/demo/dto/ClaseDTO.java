package com.mvc.demo.dto;

import java.util.Date;
import java.util.List;


public class ClaseDTO {

	private Integer idClase;
	private MonitorDTO monitor;
    private String nombre;
    private String descripcion;
    private String sala;
    private String dia;
    private Date hora;
    private Integer duracion;
    private Integer limiteMiembros;
    private List<MiembroDTO> lstMiembros;
    
	public ClaseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaseDTO(Integer idClase, MonitorDTO monitor, String nombre, String descripcion, String sala, String dia, Date hora, Integer duracion,
			Integer limiteMiembros, List<MiembroDTO> lstMiembros) {
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

	public MonitorDTO getMonitor() {
		return monitor;
	}

	public void setMonitor(MonitorDTO monitor) {
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

	public List<MiembroDTO> getLstMiembros() {
		return lstMiembros;
	}

	public void setLstMiembros(List<MiembroDTO> lstMiembros) {
		this.lstMiembros = lstMiembros;
	}
    
}
