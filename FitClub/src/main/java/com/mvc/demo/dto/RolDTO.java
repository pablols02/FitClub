package com.mvc.demo.dto;

public class RolDTO {

	private Integer idRol;
    private String descripcion;
    
	public RolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolDTO(Integer idRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
