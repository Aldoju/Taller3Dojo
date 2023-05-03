package com.trabfinal.dojo.models.dao;

import java.util.List;

import com.trabfinal.dojo.models.entity.Sensei;

public interface ISenseiDAO {
    public List<Sensei> findAll();
    public void save(Sensei sensei);
    public Sensei findOne(Long id);
    public void delete(Long id);
    

}
