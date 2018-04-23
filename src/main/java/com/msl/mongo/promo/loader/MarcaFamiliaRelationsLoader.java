package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.repository.MarcaRepository;
import com.msl.mongo.promo.repository.FamiliaRepository;


@Component
public class MarcaFamiliaRelationsLoader implements IRepositoryLoader{
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private FamiliaRepository familiaRepo;
		
	public void shareFamiliasLoad() {
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
				List<Familia> listFamilias = new ArrayList<Familia>();
				listFamilias.add(familia);
				marca.setFamilias(listFamilias);
				marcaRepo.save(marca);
			}
		}
	}
	
	public void deleteAll() {
		List<Marca> marcas = marcaRepo.findAll();
		for (Marca marca : marcas) {
			List<Familia> familiasProd = marca.getFamilias();
			if(familiasProd != null && !familiasProd.isEmpty()) {
				marca.setFamilias(Collections.<Familia>emptyList());
				marcaRepo.save(marca);
			}
		}
	}
}
