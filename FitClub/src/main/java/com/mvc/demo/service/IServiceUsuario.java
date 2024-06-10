package com.mvc.demo.service;

import java.util.List;

import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.exception.MiExcepcion;

public interface IServiceUsuario {
	public void guardarUsuario(UsuarioDTO usuarioDTO) throws MiExcepcion;
	public void actualizarUsuario(UsuarioDTO usuarioDTO);
	public void eliminarUsuario(String idUsuario);
	public UsuarioDTO obtenerUsuarioPorId(String idUsuario);
	public List<UsuarioDTO> listarTodosLosUsuarios();
}
