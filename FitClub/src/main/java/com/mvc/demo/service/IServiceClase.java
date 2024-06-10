package com.mvc.demo.service;

import java.util.List;

import com.mvc.demo.dto.ClaseDTO;

public interface IServiceClase {
	public List<ClaseDTO> obtenerClasesPorUsuarioId(String usuarioId);
	public List<ClaseDTO> listarTodosLasClases();
	public void apuntarMiembroAClase(String idLogeado, Integer idClase);
}
