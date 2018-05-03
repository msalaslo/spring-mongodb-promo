package com.msl.mongo.promo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	MarcaRepository repository;
    
    public Iterable<Marca> findByCmarmuma(String cmarmuma){
    	return repository.findByCmarmuma(cmarmuma);
    }
    
    public Iterable<Promocion> findPromocionesById(String id){
    	return repository.findPromocionesById(id);
    }
    
    public Iterable<Promocion> findPromocionesByCmarmuma(String cmarmuma){
    	return repository.findPromocionesByCmarmuma(cmarmuma);
    }

	public Marca save(Marca product) {
		return repository.save(product);
	}
}
