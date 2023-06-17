package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.IAlumnoDAO;
import com.trabfinal.dojo.models.entity.Alumno;



@Service
public class AlumnoService  implements IAlumnoService{

	@Autowired
	private  IAlumnoDAO alumnoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll(){
		return (List <Alumno>) alumnoDAO.findAll();
	}

	@Override
	@Transactional 
	public void save(Alumno alumno) {
			alumnoDAO.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findOne(Long id) {		
		return alumnoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		alumnoDAO.deleteById(id);		
	}

}
