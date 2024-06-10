package com.mvc.demo.dao;

import java.util.List;

import com.mvc.demo.entity.MiembroEntity;

public interface IDAOMiembro {
	public MiembroEntity findById(Integer idMiembro);
	public List<MiembroEntity> findAll();
}
