package com.msl.mongo.promo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Promocion;

public interface FamiliaRepository extends MongoRepository<Familia,String> {
	public Optional<Familia> findById(String id);
	public Iterable<Familia> findByCfamilia(String cfamilia);
	public Iterable<Familia> findByName(String name);
	Iterable<Promocion> findPromocionesById(String id);
	Iterable<Promocion> findPromocionesByName(String name);
	Iterable<Promocion> findPromocionesByCfamilia(String cfamilia);
}