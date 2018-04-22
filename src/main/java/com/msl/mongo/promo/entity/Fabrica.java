package com.msl.mongo.promo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fabrica")
public class Fabrica {
	
	@Id
    public String id;
	
	@Indexed
	public String cfabrica;
	
	public Fabrica(String cfabrica) {
		super();
		this.cfabrica = cfabrica;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCfabrica() {
		return cfabrica;
	}

	public void setCfabrica(String cfabrica) {
		this.cfabrica = cfabrica;
	}

}
