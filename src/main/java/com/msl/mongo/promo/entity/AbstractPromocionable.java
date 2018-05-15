package com.msl.mongo.promo.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class AbstractPromocionable implements Promocionable {
	
	private String name;
	
	// @Relations(edges = ProductoPromocion.class, lazy = true)
	@DBRef
	private List<Promocion> promociones;

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
