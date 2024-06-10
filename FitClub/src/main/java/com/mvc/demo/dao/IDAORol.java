package com.mvc.demo.dao;

import java.util.List;

import com.mvc.demo.entity.RolEntity;

public interface IDAORol {
	public RolEntity findById(Integer idRol);
	public List<RolEntity> findAll();
}
