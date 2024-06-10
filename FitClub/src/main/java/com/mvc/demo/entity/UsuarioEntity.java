package com.mvc.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_USUARIO")
	private String idUsuario;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWD")
	private String passwd;
	
	@ManyToOne
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
	private RolEntity rol;

	public UsuarioEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioEntity(String idUsuario, String nombre, String apellidos, String dni, String email, String passwd,
			com.mvc.demo.entity.RolEntity rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.passwd = passwd;
		this.rol = rol;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public RolEntity getRol() {
		return rol;
	}

	public void setRol(RolEntity rol) {
		this.rol = rol;
	}
	
}
