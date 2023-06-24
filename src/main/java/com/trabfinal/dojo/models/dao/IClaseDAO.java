package com.trabfinal.dojo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trabfinal.dojo.models.entity.Clase;

public interface IClaseDAO extends PagingAndSortingRepository<Clase, Long>, CrudRepository<Clase,Long>{

}
