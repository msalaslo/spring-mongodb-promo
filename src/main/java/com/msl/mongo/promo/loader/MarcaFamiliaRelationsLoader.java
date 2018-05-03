package com.msl.mongo.promo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.repository.FamiliaRepository;
import com.msl.mongo.promo.repository.MarcaRepository;


@Component
public class MarcaFamiliaRelationsLoader implements IRelacionableRepositoryLoader{
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private FamiliaRepository familiaRepo;
		
	@Override
	public void loadRelaciones() {
		List<Familia> familias = familiaRepo.findAll();
		List<Marca> marcas = marcaRepo.findAll();
		int numMarcas = marcas.size();
		int numFamilias = familias.size();
		int section = numMarcas/numFamilias;		
		Familia familia = familias.get(0);
		//Vamos avanzando la familias a un conjunto equitativo de marcas
		for(int i = 0; i<numFamilias; i++) {
			familia = familias.get(i);
			int iniSection = i*section;
			int endSection = iniSection + section;
			for (int j = iniSection; j<endSection; j++) {			
				Marca marca = marcas.get(j);
//				System.out.println("Asociando el marca " + marca + " a la familia " + familia );
				marca.setFamilia(familia);
				marcaRepo.save(marca);
			}
		}
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
}
