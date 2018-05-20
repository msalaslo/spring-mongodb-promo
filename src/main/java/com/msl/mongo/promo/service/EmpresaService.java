package com.msl.mongo.promo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository repository;
	
    public Optional<Empresa> findByid(String id){
    	return repository.findById(id);
    }
    
    public Iterable<Empresa> findByName(String name){
    	return repository.findByName(name);
    }
    
    public Iterable<Empresa> findByCempresa(String cempresa){
    	return repository.findByCempresa(cempresa);
    }
    
    public Iterable<Promocion> findPromocionesById(String id){
    	return repository.findPromocionesById(id);
    }
    
    public Iterable<Promocion> findPromocionesByCempresa(String cempresa){
    	return repository.findPromocionesByCempresa(cempresa);
    }
    
    public Iterable<Promocion> findPromocionesByName(String name){
    	return repository.findPromocionesByName(name);
    }

	public Empresa save(Empresa product) {
		return repository.save(product);
	}
}
