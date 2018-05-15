package com.msl.mongo.promo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="empresa")
public class Empresa implements Promocionable,RelacionableParent{
	
	@Id
    public String id;
		
	@Indexed
	public String cempresa;
	
	public String name;
	
//	@Relations(edges = ProductoPromocion.class, lazy = true)
	@DBRef
	private List<Promocion> promociones;
	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	public Empresa(String cempresa, String name) {
		super();
		this.cempresa = cempresa;
		this.name= name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCempresa() {
		return cempresa;
	}

	public void setCempresa(String cempresa) {
		this.cempresa = cempresa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
