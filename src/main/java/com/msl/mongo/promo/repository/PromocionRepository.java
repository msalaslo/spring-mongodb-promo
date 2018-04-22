package com.msl.mongo.promo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msl.mongo.promo.entity.Promocion;
 
public interface PromocionRepository extends MongoRepository<Promocion,String> {
	@SuppressWarnings("unchecked")
	public Promocion save(Promocion promocion);
	public List<Promocion> saveAll(List<Promocion> promociones);
//    public Promocion findOne(String id);
	public Promocion findByCodpromoci(String codpromoci);
    public List<Promocion> findByCanlvnta(String canlvnta);   
    public List<Promocion> findAll();
}