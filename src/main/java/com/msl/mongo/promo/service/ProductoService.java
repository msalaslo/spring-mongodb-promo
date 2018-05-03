package com.msl.mongo.promo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repository;
	
//    public Producto findByid(String id){
//    	return repository.findOne(id);
//    }
    
    public Iterable<Producto> findByReferencia(String referencia){
    	return repository.findByReferencia(referencia);
    }
    
    public Iterable<Promocion> findPromocionesByReferencia(String referencia){
    	return repository.findPromocionesByReferencia(referencia);
    }

	public Producto save(Producto product) {
		return repository.save(product);
	}
}
