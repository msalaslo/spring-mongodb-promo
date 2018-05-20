package com.msl.mongo.promo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Centro;
import com.msl.mongo.promo.entity.Promocion;

public interface CentroRepository extends MongoRepository<Centro,String> {
	public Optional<Centro> findById(String id);
	public Iterable<Centro> findByCentroo(String centroo);
	public Iterable<Centro> findByName(String centroo);
	public Iterable<Promocion> findPromocionesByCentroo(String centroo);
	public Iterable<Promocion> findPromocionesById(String id);
	public Iterable<Promocion> findPromocionesByName(String name);
}