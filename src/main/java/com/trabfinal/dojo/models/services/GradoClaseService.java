package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.dojo.models.dao.GradoClaseDAO;
import com.trabfinal.dojo.models.entity.Grado;
import com.trabfinal.dojo.models.entity.GradoClase;
import com.trabfinal.dojo.models.entity.GradoClaseId;

@Service
public class GradoClaseService implements IGradoClaseService{
    
    @Autowired
    private GradoClaseDAO gradoClaseDAO;

    @Override
    public void delete(GradoClaseId id){
        gradoClaseDAO.deleteById(id);
    }

    @Override
    public List<GradoClase>findAll(){
        return gradoClaseDAO.findAll();
    }

    @Override
	@Transactional 
	public void save(GradoClase gradoClase) {
			gradoClaseDAO.save(gradoClase);
	}

    @Override
    public GradoClase findOne(GradoClaseId id){
        return gradoClaseDAO.findById(id).orElseThrow(null);

    }

    @Override
    @Transactional(readOnly=true)
    public Page<GradoClase> findAll(Pageable pageable){
        return gradoClaseDAO.findAll(pageable);
    }

}
