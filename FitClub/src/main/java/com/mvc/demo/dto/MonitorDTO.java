package com.mvc.demo.dto;

public class MonitorDTO {

	private Integer idMonitor;
    private UsuarioDTO usuario;
    
	public MonitorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitorDTO(Integer idMonitor, UsuarioDTO usuario) {
		super();
		this.idMonitor = idMonitor;
		this.usuario = usuario;
	}

	public Integer getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(Integer idMonitor) {
		this.idMonitor = idMonitor;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
    
}
