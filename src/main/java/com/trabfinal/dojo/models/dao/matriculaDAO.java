package com.trabfinal.dojo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.trabfinal.dojo.models.entity.Matricula;


public interface matriculaDAO extends PagingAndSortingRepository<Matricula, Long>,CrudRepository<Matricula,Long>{

}
