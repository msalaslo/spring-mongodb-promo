package com.msl.mongo.promo.entity;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="producto")
public class Producto {
	
	@Id
    public String id;
	
	@Indexed
	public String referencia;
	
	public String name;
	
//	@Relations(edges = ProductoPromocion.class, lazy = true)
	private Collection<Promocion> promociones;
	
//	@Relations(edges = ProductoMarca.class, lazy = true)
	private Collection<Marca> marcas;
	
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

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	public Collection<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(Collection<Marca> marcas) {
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