package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Relacionable;
import com.msl.mongo.promo.entity.RelacionableParent;
import com.msl.mongo.promo.repository.FamiliaRepository;
import com.msl.mongo.promo.repository.MarcaRepository;


@Component
public class MarcaFamiliaRelationsLoader extends AbstractRelacionableRepositoryLoader implements IRelacionableRepositoryLoader{
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private FamiliaRepository familiaRepo;
		
	@Override
	public void loadRelaciones() {
		List<Familia> familias = familiaRepo.findAll();
		List<Marca> marcas = marcaRepo.findAll();
		List<Relacionable> relacionables = new ArrayList<Relacionable>();
		for (Marca marca : marcas) {
			relacionables.add((Relacionable)marca);
		}
		
		List<RelacionableParent> parents = new ArrayList<RelacionableParent>();
		for (Familia familia : familias) {
			parents.add((RelacionableParent)familia);
		}
		
		super.loadRelaciones(relacionables, parents);
	}
	
	@Override
	public void deleteRelaciones() {
		List<Marca> marcas = marcaRepo.findAll();
		for (Marca marca : marcas) {
			Familia familiasProd = marca.getFamilia();
			if(familiasProd != null) {
				marca.setFamilia(null);
				marcaRepo.save(marca);
			}
		}
	}

	@Override
	public void save(Relacionable relacionable, RelacionableParent parent) {
		Marca marca = (Marca)relacionable;
		marca.setFamilia((Familia)parent);
		marcaRepo.save(marca);
	}
}
