package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.entity.Promocionable;
import com.msl.mongo.promo.repository.FamiliaRepository;


@Component
public class FamiliaPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private FamiliaRepository repository;
		
	@Override
	public void loadPromociones() {
		List<Familia> familias = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Familia familia : familias) {
			promocionables.add((Promocionable)familia);
		}
		super.loadPromociones(promocionables);
	}

	@Override
	public void deletePromociones() {
		List<Familia> familias = repository.findAll();
		for (Familia familia : familias) {
			List<Promocion> promocionesProd = familia.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				familia.setPromociones(Collections.<Promocion>emptyList());
				repository.save(familia);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Familia)promocionable);
	}
}
