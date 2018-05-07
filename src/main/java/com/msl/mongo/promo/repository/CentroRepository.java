package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Centro;
import com.msl.mongo.promo.entity.Promocion;

public interface CentroRepository extends MongoRepository<Centro,String> {
	public List<Centro> findByCentroo(String centroo);
	List<Promocion> findPromocionesByCcentroo(String centroo);
}