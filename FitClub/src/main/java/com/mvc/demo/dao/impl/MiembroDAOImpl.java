package com.mvc.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.demo.dao.IDAOMiembro;
import com.mvc.demo.entity.MiembroEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class MiembroDAOImpl implements IDAOMiembro {

	@PersistenceContext
    private EntityManager em;

	@Override
	public MiembroEntity findById(Integer idMiembro) {
		MiembroEntity miembro = null;
		System.out.println(idMiembro);
		try {
			miembro = em.find(MiembroEntity.class, idMiembro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return miembro;
	}

	@Override
	public List<MiembroEntity> findAll() {
		List<MiembroEntity> miembros = null;
        TypedQuery<MiembroEntity> query;

        try {
            query = em.createQuery("SELECT m FROM MiembroEntity m", MiembroEntity.class);
            miembros = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return miembros;
	}
	
	
}
