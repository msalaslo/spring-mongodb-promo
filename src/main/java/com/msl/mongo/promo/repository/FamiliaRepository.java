package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Promocion;

public interface FamiliaRepository extends MongoRepository<Familia,String> {
	public List<Familia> findByCfamilia(String cfamilia);
	List<Promocion> findPromocionesByCfamilia(String cfamilia);
}