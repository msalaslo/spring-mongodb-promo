package com.msl.mongo.promo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="empresa")
public class Empresa {
	
	@Id
    public String id;
		
	@Indexed
	public String cempresa;
	
	public Empresa(String cempresa) {
		super();
		this.cempresa = cempresa;
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

}
