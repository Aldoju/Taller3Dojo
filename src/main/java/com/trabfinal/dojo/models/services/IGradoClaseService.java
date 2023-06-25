package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabfinal.dojo.models.entity.GradoClase;
import com.trabfinal.dojo.models.entity.GradoClaseId;

public interface IGradoClaseService {
    public List<GradoClase> findAll();
    public Page<GradoClase> findAll(Pageable pageable);
    public void save(GradoClase gradoClase);
    public GradoClase findOne(GradoClaseId id);
    public void delete(GradoClaseId id);
}
