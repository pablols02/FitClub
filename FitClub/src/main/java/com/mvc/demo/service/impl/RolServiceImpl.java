package com.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.demo.dao.IDAORol;
import com.mvc.demo.dto.RolDTO;
import com.mvc.demo.entity.RolEntity;
import com.mvc.demo.service.IServiceRol;

@Service
public class RolServiceImpl implements IServiceRol {

	@Autowired
	private IDAORol rolDAO;
	
	@Override
	@Transactional(readOnly = true)
	public RolDTO obtenerRolPorId(Integer idRol) {
		RolEntity rolEntity = rolDAO.findById(idRol);
		RolDTO rolDTO = null;
	    	try {
	    		rolDTO = new RolDTO();
	    		rolDTO.setIdRol(rolEntity.getIdRol());
	    		rolDTO.setDescripcion(rolEntity.getDescripcion());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

	    return rolDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RolDTO> listarTodosLosRoles() {
		List<RolEntity> rolesEntities = rolDAO.findAll();
	    List<RolDTO> rolesDTO = new ArrayList<>();
	    for (RolEntity rolEntity : rolesEntities) {
	    	RolDTO rolDTO = new RolDTO();
	    	rolDTO.setIdRol(rolEntity.getIdRol());
	    	rolDTO.setDescripcion(rolEntity.getDescripcion());
	    	rolesDTO.add(rolDTO);
	    }
	    return rolesDTO;
	}

}
