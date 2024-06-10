package com.mvc.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.demo.dao.IDAOUsuario;
import com.mvc.demo.entity.UsuarioEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioDAOImpl implements IDAOUsuario {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(UsuarioEntity usuario) {
		try {
			em.persist(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void merge(UsuarioEntity usuario) {
		try {
	        em.merge(usuario);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	@Override
	public void remove(UsuarioEntity usuario) {
		try {
			em.remove(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public UsuarioEntity findById(String idUsuario) {
		UsuarioEntity usuario = null;
		System.out.println(idUsuario);
		try {
			usuario = em.find(UsuarioEntity.class, idUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return usuario;
	}
	
	@Override
	public List<UsuarioEntity> findAll() {
		List<UsuarioEntity> usuarios = null;
        TypedQuery<UsuarioEntity> query;

        try {
            query = em.createQuery("SELECT u FROM UsuarioEntity u", UsuarioEntity.class);
            usuarios = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return usuarios;
	}
	
}
