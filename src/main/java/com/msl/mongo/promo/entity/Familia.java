package com.msl.mongo.promo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="familia")
public class Familia {
	
	@Id
    public String id;
	
	@Indexed
	public String cfamilia;
	
	@DBRef
	public List<Promocion> promociones;
	
	public String name;
	
	public Familia(String cfamilia, String name) {
		super();
		this.cfamilia = cfamilia;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCfamilia() {
		return cfamilia;
	}

	public void setCfamilia(String cfamilia) {
		this.cfamilia = cfamilia;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

}
