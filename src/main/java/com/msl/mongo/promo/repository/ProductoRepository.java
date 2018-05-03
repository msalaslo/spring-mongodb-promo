package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;

public interface ProductoRepository extends MongoRepository<Producto,String> {
	public List<Producto> findByReferencia(String referencia);
	public Producto findByName(String name);
	List<Promocion> findPromocionesByReferencia(String referencia);
}