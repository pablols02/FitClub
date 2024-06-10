package com.mvc.demo.dao;

import java.util.List;

import com.mvc.demo.entity.ClaseEntity;

public interface IDAOClases {
	public List<ClaseEntity> findClasesByUsuarioId(String usuarioId);
	public List<ClaseEntity> findAll();
	public ClaseEntity findById(Integer idClase);
}
