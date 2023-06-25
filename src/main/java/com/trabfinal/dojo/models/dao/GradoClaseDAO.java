package com.trabfinal.dojo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.trabfinal.dojo.models.entity.GradoClase;
import com.trabfinal.dojo.models.entity.GradoClaseId;

public interface GradoClaseDAO extends JpaRepository<GradoClase,GradoClaseId>{
    
}
