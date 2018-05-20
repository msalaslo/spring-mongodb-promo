package com.msl.mongo.promo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.entity.Promocion;

public interface EmpresaRepository extends MongoRepository<Empresa,String> {
	public Optional<Empresa> findById(String id);
	public Iterable<Empresa> findByCempresa(String cempresa);
	public Iterable<Empresa> findByName(String cempresa);
	public Iterable<Promocion> findPromocionesByCempresa(String cempresa);
	public Iterable<Promocion> findPromocionesById(String id);
	public Iterable<Promocion> findPromocionesByName(String name);
}