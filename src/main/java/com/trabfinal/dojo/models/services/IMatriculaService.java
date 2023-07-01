package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabfinal.dojo.models.entity.Matricula;

public interface IMatriculaService {
    public List<Matricula> findAll();
    public Page<Matricula> findAll(Pageable pageable);
    public void save(Matricula cliente);
    public Matricula findOne(Long id);
    public void delete(Long id);   
}
