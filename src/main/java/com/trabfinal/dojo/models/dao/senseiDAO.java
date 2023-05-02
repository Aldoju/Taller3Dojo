package com.trabfinal.dojo.models.dao;

import java.util.List;

import com.trabfinal.dojo.models.entity.Sensei;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// public class senseiDAO implements ISenseiDAO{
//     @PersistenceContext
//     private EntityManager sen;
    
//     @Override
//     public List<Sensei> findAll(){
//         return sen.createQuery("from Sensei ",Sensei.class).getResultList();
//     }

//     @Override
// 	public void save(Sensei ob) {
// 		if(ob.getIdSensei()!=null && ob.getIdSensei()>0) {
// 			sen.merge(ob);
// 		}else {
// 			sen.persist(ob);
// 		}		
// 	}

//     @Override
// 	public Sensei findOne(Long id) {		
// 		return sen.find(Sensei.class, id);
// 	}

//     @Override
// 	public void delete(Long id) {
// 		sen.remove(id);		
// 	}
// }
