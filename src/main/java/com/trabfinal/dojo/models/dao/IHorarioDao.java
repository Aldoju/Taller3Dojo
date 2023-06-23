package com.trabfinal.dojo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trabfinal.dojo.models.entity.Horario;

public interface IHorarioDao extends PagingAndSortingRepository<Horario, Long>, CrudRepository<Horario,
Long> {
}