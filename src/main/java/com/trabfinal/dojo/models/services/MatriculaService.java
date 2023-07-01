package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.matriculaDAO;
import com.trabfinal.dojo.models.entity.Matricula;

@Service
public class MatriculaService implements IMatriculaService{
    @Autowired
	private  matriculaDAO matriculaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll(){
		return (List <Matricula>) matriculaDAO.findAll();
	}

	@Override
	@Transactional 
	public void save(Matricula matricula) {
			matriculaDAO.save(matricula);
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findOne(Long id) {		
		return matriculaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		matriculaDAO.deleteById(id);		
	}

	@Override
    @Transactional(readOnly=true)
    public Page<Matricula> findAll(Pageable pageable){
        return matriculaDAO.findAll(pageable);
    }
}
