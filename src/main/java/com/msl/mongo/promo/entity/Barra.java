package com.msl.mongo.promo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="barra")
public class Barra {
	
	@Id
    public String id;
	
	@Indexed
	public String cbarraaa;
	
	public Barra(String cbarraaa) {
		super();
		this.cbarraaa = cbarraaa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCbarraaa() {
		return cbarraaa;
	}

	public void setCbarraaa(String cbarraaa) {
		this.cbarraaa = cbarraaa;
	}

}
