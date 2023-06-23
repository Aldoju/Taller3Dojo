package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.IHorarioDao;
import com.trabfinal.dojo.models.entity.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {
    @Autowired
    private IHorarioDao horarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Horario> findAll(){
        return (List<Horario>) horarioDao.findAll();
    }
    @Override
    @Transactional
    public void save(Horario horario){
        horarioDao.save(horario);
    }

    @Override
    @Transactional(readOnly=true)
    public Horario findOne(Long id){
        return horarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id){
        horarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Horario> findAll(Pageable pageable){
        return horarioDao.findAll(pageable);
    }
}
