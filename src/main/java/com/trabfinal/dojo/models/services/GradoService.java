package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.IGradoDAO;
import com.trabfinal.dojo.models.entity.Grado;


@Service
public class GradoService implements IGradoService{
    @Autowired
	private  IGradoDAO gradoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Grado> findAll(){
		return (List <Grado>) gradoDAO.findAll();
	}

	@Override
	@Transactional 
	public void save(Grado grado) {
			gradoDAO.save(grado);
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findOne(Long id) {		
		return gradoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		gradoDAO.deleteById(id);		
	}

	@Override
    @Transactional(readOnly=true)
    public Page<Grado> findAll(Pageable pageable){
        return gradoDAO.findAll(pageable);
    }
}
