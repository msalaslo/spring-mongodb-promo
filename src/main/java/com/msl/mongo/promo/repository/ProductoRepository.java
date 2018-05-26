package com.msl.mongo.promo.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;

public interface ProductoRepository extends MongoRepository<Producto,String> {
	public Optional<Producto> findById(String id);
	public Iterable<Producto> findByReferencia(String referencia);
	public Producto findByName(String name);
	public List<Producto> findAll();
	Iterable<Promocion> findPromocionesById(String id);
	Iterable<Promocion> findPromocionesByName(String name);
	Iterable<Promocion> findPromocionesByReferencia(String referencia);
	@Query("{}")
	public Stream<Producto> findAllAsStream();
}