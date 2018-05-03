package com.msl.mongo.promo.entity;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="producto")
public class Producto implements Promocionable{
	
	@Id
    public String id;
	
	@Indexed
	public String referencia;
	
	public String name;
	
//	@Relations(edges = ProductoPromocion.class, lazy = true)
	@DBRef
	private List<Promocion> promociones;
	
//	@Relations(edges = ProductoMarca.class, lazy = true)
	@DBRef
	private List<Marca> marcas;
	
	public Producto(String referencia, String name) {
		super();
		this.referencia = referencia;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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
	
	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
    @Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("PRODUCTO:" + name).
        		append("id", id).
                append("referencia", referencia).
                append("promociones", promociones).
          	    append("marcas", marcas).
        		toString();
    }
}
