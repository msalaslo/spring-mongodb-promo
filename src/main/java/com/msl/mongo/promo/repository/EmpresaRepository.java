package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.entity.Promocion;

public interface EmpresaRepository extends MongoRepository<Empresa,String> {
	public List<Empresa> findByCempresa(String cempresa);
	List<Promocion> findPromocionesByCempresa(String cempresa);
}