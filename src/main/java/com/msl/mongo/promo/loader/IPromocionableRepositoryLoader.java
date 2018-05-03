package com.msl.mongo.promo.loader;

import java.util.List;

import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.entity.Promocionable;

public interface IPromocionableRepositoryLoader {
	public void loadPromociones();
	public void deletePromociones();
	public void loadPromociones(List<Promocionable> promocionables);
	public void save(Promocionable promocionable, Promocion promocion);
}
