package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabfinal.dojo.models.entity.Grado;

public interface IGradoService {
    public List<Grado> findAll();
	public Page<Grado> findAll(Pageable pageable);
	public void save(Grado grado);
	public Grado findOne(Long id);
	public  void delete(Long id);
}
