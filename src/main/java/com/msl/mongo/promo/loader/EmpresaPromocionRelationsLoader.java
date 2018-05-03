package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.entity.Promocionable;
import com.msl.mongo.promo.repository.EmpresaRepository;


@Component
public class EmpresaPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public void loadPromociones() {
		List<Empresa> empresas = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Empresa empresa : empresas) {
			promocionables.add((Promocionable)empresa);
		}
		super.loadPromociones(promocionables);
	}
		

	@Override
	public void deletePromociones() {
		List<Empresa> empresas = repository.findAll();
		for (Empresa empresa : empresas) {
			List<Promocion> promocionesProd = empresa.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				empresa.setPromociones(Collections.<Promocion>emptyList());
				repository.save(empresa);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Empresa)promocionable);
	}

}
