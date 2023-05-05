package com.trabfinal.dojo.models.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.trabfinal.dojo.models.entity.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AlumnoDAO implements IAlumnoDAO{

	@PersistenceContext
	private EntityManager em; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findAll() {		
		return em.createQuery("from Alumno").getResultList();
	}

	@Override
	public void save(Alumno alumno) {
		if(alumno.getId()!=null && alumno.getId()>0) {
			em.merge(alumno);
		}else {
			em.persist(alumno);
		}		
	}

	@Override
	public Alumno findOne(Long id) {		
		return em.find(Alumno.class, id);
	}

	@Override
	public void delete(Long id) {
		//em.remove(id);		
		em.remove(findOne(id));
	}

}
