package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.IClaseDAO;
import com.trabfinal.dojo.models.entity.Clase;
import com.trabfinal.dojo.models.entity.Horario;

@Service
public class ClaseService implements IClaseService{
    @Autowired
	private  IClaseDAO claseDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Clase> findAll(){
		return (List <Clase>) claseDAO.findAll();
	}

	@Override
	@Transactional 
	public void save(Clase clase) {
			claseDAO.save(clase);
	}

	@Override
	@Transactional(readOnly = true)
	public Clase findOne(Long id) {		
		return claseDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		claseDAO.deleteById(id);		
	}

	@Override
    @Transactional(readOnly=true)
    public Page<Clase> findAll(Pageable pageable){
        return claseDAO.findAll(pageable);
    }
}
