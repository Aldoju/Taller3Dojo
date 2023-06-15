package com.trabfinal.dojo.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trabfinal.dojo.models.entity.Alumno;

public interface IAlumnoDAO extends PagingAndSortingRepository<Alumno, Long>,CrudRepository<Alumno,Long>{

}
