package com.msl.mongo.promo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Promocion;

public interface MarcaRepository extends MongoRepository<Marca,String> {
	public Optional<Marca> findById(String id);
	public Iterable<Marca> findByCmarmuma(String cmarmuma);
	public Iterable<Marca> findByName(String name);
	public Iterable<Promocion> findPromocionesById(String id);
	public Iterable<Promocion> findPromocionesByName(String name);
	public Iterable<Promocion> findPromocionesByCmarmuma(String cmarmuma);
}