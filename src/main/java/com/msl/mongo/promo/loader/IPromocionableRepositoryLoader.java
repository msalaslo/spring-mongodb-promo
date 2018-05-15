package com.msl.mongo.promo.loader;

import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.entity.Promocionable;

public interface IPromocionableRepositoryLoader {
	public void loadPromociones();
	public void deletePromociones();
	public void loadPromociones(Iterable<Promocionable> promocionables);
	public void save(Promocionable promocionable, Promocion promocion);
}
