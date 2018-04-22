package com.msl.mongo.promo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Promocion;

public interface MarcaRepository extends MongoRepository<Marca,String> {
	@SuppressWarnings("unchecked")
	public Marca save(Marca marca);
	public List<Marca> saveAll(Collection<Marca> marcas);
	public List<Marca> findByCmarmuma(String cmarmuma);
	public List<Marca> findByName(String name);
	public List<Marca> findAll();
	List<Promocion> findPromocionesById(String id);
	List<Promocion> findPromocionesByName(String name);
	List<Promocion> findPromocionesByCmarmuma(String cmarmuma);
}