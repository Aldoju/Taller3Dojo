package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabfinal.dojo.models.entity.Clase;



public interface IClaseService {
    public List<Clase> findAll();
	public Page<Clase> findAll(Pageable pageable);
	public void save(Clase clase);
	public Clase findOne(Long id);
	public  void delete(Long id);
}
