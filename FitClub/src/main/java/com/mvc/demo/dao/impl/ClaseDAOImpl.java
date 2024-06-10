package com.mvc.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.demo.dao.IDAOClases;
import com.mvc.demo.entity.ClaseEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ClaseDAOImpl implements IDAOClases {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ClaseEntity> findClasesByUsuarioId(String usuarioId) {
        TypedQuery<ClaseEntity> query = em.createQuery(
            "SELECT c FROM ClaseEntity c " +
            "JOIN c.lstMiembros m " +
            "JOIN m.usuario u " +
            "WHERE u.idUsuario = :usuarioId", ClaseEntity.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }

	@Override
	public List<ClaseEntity> findAll() {
		List<ClaseEntity> clases = null;
        TypedQuery<ClaseEntity> query;

        try {
            query = em.createQuery("SELECT c FROM ClaseEntity c", ClaseEntity.class);
            clases = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return clases;
	}
	
	@Override
	public ClaseEntity findById(Integer idClase) {
		ClaseEntity clase = null;
		System.out.println(idClase);
		try {
			clase = em.find(ClaseEntity.class, idClase);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return clase;
	}

}