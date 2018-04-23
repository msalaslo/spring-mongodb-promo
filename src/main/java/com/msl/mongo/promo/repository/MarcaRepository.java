package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Promocion;

public interface MarcaRepository extends MongoRepository<Marca,String> {
	public List<Marca> findByCmarmuma(String cmarmuma);
	public List<Marca> findByName(String name);
	public List<Marca> findAll();
	List<Promocion> findPromocionesById(String id);
	List<Promocion> findPromocionesByCmarmuma(String cmarmuma);
}