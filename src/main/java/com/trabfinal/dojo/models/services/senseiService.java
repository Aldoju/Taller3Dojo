package com.trabfinal.dojo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.dojo.models.dao.ISenseiDAO;
import com.trabfinal.dojo.models.entity.Sensei;

import org.springframework.transaction.annotation.Transactional;

@Service
public class senseiService implements ISenseiService {
    
	@Autowired
    private ISenseiDAO senseiDao;
    
	@Override
	@Transactional(readOnly = true)
	public List<Sensei> findAll(){
		return (List<Sensei>) senseiDao.findAll();
	}
	
    @Override
	@Transactional 
	public void save(Sensei sensei) {
			senseiDao.save(sensei);
	}

	@Override
	@Transactional(readOnly = true)
	public Sensei findOne(Long id) {		
		return senseiDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		senseiDao.deleteById(id);		
	}



}
