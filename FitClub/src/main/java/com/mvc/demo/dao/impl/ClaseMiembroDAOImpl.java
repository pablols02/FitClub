package com.mvc.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.mvc.demo.dao.IDAOClaseMiembro;
import com.mvc.demo.entity.ClaseMiembroEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClaseMiembroDAOImpl implements IDAOClaseMiembro {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(ClaseMiembroEntity claseMiembro) {
		try {
			em.persist(claseMiembro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
