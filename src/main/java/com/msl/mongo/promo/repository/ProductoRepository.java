package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;

public interface ProductoRepository extends MongoRepository<Producto,String> {
	@SuppressWarnings("unchecked")
	public Producto save(Producto producto);
	public List<Producto> saveAll(List<Producto> producto);
//	public Producto findOne(String id);
	public List<Producto> findByReferencia(String referencia);
	public Producto findByName(String name);
	public List<Producto> findAll();
	List<Promocion> findPromocionesById(String id);
	List<Promocion> findPromocionesByName(String name);
	List<Promocion> findPromocionesByReferencia(String referencia);
	List<Producto> findByPromocionesCodpromoci(String codpromoci);
}