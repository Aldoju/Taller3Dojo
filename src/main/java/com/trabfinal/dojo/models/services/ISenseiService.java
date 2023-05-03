package com.trabfinal.dojo.models.services;

import java.util.List;

import com.trabfinal.dojo.models.entity.Sensei;

public interface ISenseiService {

    public List<Sensei> findAll();
    public void save(Sensei sensei);
	public Sensei findOne(Long id);
	public  void delete(Long id);
    
}
