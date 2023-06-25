package com.trabfinal.dojo.models.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trabfinal.dojo.models.entity.Grado;


public interface IGradoDAO extends PagingAndSortingRepository<Grado, Long>, CrudRepository<Grado,
Long> {
}