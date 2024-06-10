package com.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.demo.dao.IDAORol;
import com.mvc.demo.dao.IDAOUsuario;
import com.mvc.demo.dto.RolDTO;
import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.entity.RolEntity;
import com.mvc.demo.entity.UsuarioEntity;
import com.mvc.demo.exception.MiExcepcion;
import com.mvc.demo.service.IServiceUsuario;

@Service
public class UsuarioServiceImpl implements IServiceUsuario {

	@Autowired
	private IDAOUsuario usuarioDAO;
	
	@Autowired
	private IDAORol rolDAO;

	@Override
	@Transactional
	public void guardarUsuario(UsuarioDTO usuarioDTO) throws MiExcepcion {
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = usuarioDAO.findById(usuarioDTO.getIdUsuario());
			
			if (null != usuarioEntity || usuarioDTO.getIdUsuario() == "") {
				throw new MiExcepcion(100, "Error en usuario duplicado");
			}
			
			usuarioEntity = new UsuarioEntity();
			usuarioEntity.setIdUsuario(usuarioDTO.getIdUsuario());
			usuarioEntity.setNombre(usuarioDTO.getNombre());
			usuarioEntity.setApellidos(usuarioDTO.getApellidos());
			usuarioEntity.setDni(usuarioDTO.getDni());
			usuarioEntity.setEmail(usuarioDTO.getEmail());
			usuarioEntity.setPasswd(usuarioDTO.getPasswd());
			Integer idRol = 1;
			RolEntity rolEntity = rolDAO.findById(idRol);
			if(rolEntity != null) {
				usuarioEntity.setRol(rolEntity);
			}
			
			usuarioDAO.save(usuarioEntity);
		} catch (MiExcepcion e) {
			throw e;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	@Transactional
	public void actualizarUsuario(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = usuarioDAO.findById(usuarioDTO.getIdUsuario());
		
		if(usuarioEntity != null) {
			usuarioEntity.setIdUsuario(usuarioDTO.getIdUsuario());
			usuarioEntity.setNombre(usuarioDTO.getNombre());
			usuarioEntity.setApellidos(usuarioDTO.getApellidos());
			usuarioEntity.setDni(usuarioDTO.getDni());
			usuarioEntity.setEmail(usuarioDTO.getEmail());
			usuarioEntity.setPasswd(usuarioDTO.getPasswd());
			
			RolDTO rolDTO = usuarioDTO.getRol();
			if(rolDTO != null) {
				RolEntity rolEntity = new RolEntity();
				rolEntity.setIdRol(rolDTO.getIdRol());
				rolEntity.setDescripcion(rolDTO.getDescripcion());
				
				usuarioEntity.setRol(rolEntity);
			} else {
				usuarioEntity.setRol(null);
			}
			
			try {
				usuarioDAO.merge(usuarioEntity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	@Transactional
	public void eliminarUsuario(String idUsuario) {
		UsuarioEntity usuario = usuarioDAO.findById(idUsuario);
		try {
			usuarioDAO.remove(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO obtenerUsuarioPorId(String idUsuario) {
	    UsuarioEntity usuarioEntity = usuarioDAO.findById(idUsuario);
	    UsuarioDTO usuarioDTO = null;

	    if (usuarioEntity != null) {
	        usuarioDTO = new UsuarioDTO();
	        usuarioDTO.setIdUsuario(usuarioEntity.getIdUsuario());
	        usuarioDTO.setNombre(usuarioEntity.getNombre());
	        usuarioDTO.setApellidos(usuarioEntity.getApellidos());
	        usuarioDTO.setDni(usuarioEntity.getDni());
	        usuarioDTO.setEmail(usuarioEntity.getEmail());
	        usuarioDTO.setPasswd(usuarioEntity.getPasswd());

	        RolEntity rolEntity = usuarioEntity.getRol();
	        RolDTO rolDTO = new RolDTO();
	        rolDTO.setIdRol(rolEntity.getIdRol());
	        rolDTO.setDescripcion(rolEntity.getDescripcion());
	        usuarioDTO.setRol(rolDTO);
	    }

	    return usuarioDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDTO> listarTodosLosUsuarios() {
		List<UsuarioEntity> usuariosEntities = usuarioDAO.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		
		for (UsuarioEntity usuarioEntity : usuariosEntities) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdUsuario(usuarioEntity.getIdUsuario());
			usuarioDTO.setNombre(usuarioEntity.getNombre());
			usuarioDTO.setApellidos(usuarioEntity.getApellidos());
			usuarioDTO.setDni(usuarioEntity.getDni());
			usuarioDTO.setEmail(usuarioEntity.getEmail());
			usuarioDTO.setPasswd(usuarioEntity.getPasswd());
			
			RolEntity rolEntity = usuarioEntity.getRol();
			RolDTO rolDTO = new RolDTO();
			rolDTO.setIdRol(rolEntity.getIdRol());
			rolDTO.setDescripcion(rolEntity.getDescripcion());
			usuarioDTO.setRol(rolDTO);
			
			usuariosDTO.add(usuarioDTO);
		}
		return usuariosDTO;
	}
}
