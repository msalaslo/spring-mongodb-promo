package com.msl.mongo.promo.entity;

import java.util.List;

public interface Promocionable {
	
	public List<Promocion> getPromociones();
	public void setPromociones(List<Promocion> promociones);

}
