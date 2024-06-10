package com.mvc.demo.dto;

public class UsuarioDTO {

	private String idUsuario;
	private String passwd;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private RolDTO rol;
    
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String idUsuario, String passwd, String nombre, String apellidos, String dni, String email) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.passwd = passwd;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
}
