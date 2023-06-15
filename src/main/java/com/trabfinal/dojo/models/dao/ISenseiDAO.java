package com.trabfinal.dojo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trabfinal.dojo.models.entity.Sensei;

public interface ISenseiDAO extends PagingAndSortingRepository<Sensei, Long>,CrudRepository<Sensei,Long>{

}
