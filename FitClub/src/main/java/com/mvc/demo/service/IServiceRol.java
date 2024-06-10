package com.mvc.demo.service;

import java.util.List;

import com.mvc.demo.dto.RolDTO;

public interface IServiceRol {
	public RolDTO obtenerRolPorId(Integer idRol);
	public List<RolDTO> listarTodosLosRoles();
}
