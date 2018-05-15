package com.msl.mongo.promo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="centro")
public class Centro extends AbstractPromocionable implements Relacionable,RelacionableParent {
	
	@Id
    public String id;
	
	@Indexed
	public String centroo;
	
	public Centro(String centroo, String name) {
		super();
		this.centroo = centroo;
		super.setName(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCentroo() {
		return centroo;
	}

	public void setCentroo(String centroo) {
		this.centroo = centroo;
	}



}
