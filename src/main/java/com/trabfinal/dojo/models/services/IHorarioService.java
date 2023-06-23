package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabfinal.dojo.models.entity.Horario;

public interface IHorarioService {
    public List<Horario> findAll();
    public Page<Horario> findAll(Pageable pageable);
    public void save(Horario cliente);
    public Horario findOne(Long id);
    public void delete(Long id);
}
