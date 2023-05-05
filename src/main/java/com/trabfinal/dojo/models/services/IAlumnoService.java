package com.trabfinal.dojo.models.services;

import java.util.List;

import com.trabfinal.dojo.models.entity.Alumno;

public interface IAlumnoService {

	public List<Alumno> findAll();
	public void save(Alumno alumno);
	public Alumno findOne(Long id);
	public  void delete(Long id);
}


