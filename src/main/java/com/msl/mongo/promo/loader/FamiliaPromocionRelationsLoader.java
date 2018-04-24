package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.FamiliaRepository;
import com.msl.mongo.promo.repository.PromocionRepository;


@Component
public class FamiliaPromocionRelationsLoader implements IRepositoryLoader{
	@Autowired
	private FamiliaRepository familiaRepo;
	
	@Autowired
	private PromocionRepository promocionRepo;
		
	public void shareFamiliasLoad() {
		List<Promocion> promociones = promocionRepo.findAll();
		List<Familia> familias = familiaRepo.findAll();
		int numFamilias = familias.size();
		int numPromociones = promociones.size();
		int section = numFamilias/numPromociones;		
		Promocion promocion = promociones.get(0);
		//Vamos avanzando la promociones a un conjunto equitativo de familias
		for(int i = 0; i<numPromociones; i++) {
			promocion = promociones.get(i);
			int iniSection = i*section;
			int endSection = iniSection + section;
			for (int j = iniSection; j<endSection; j++) {			
				Familia familia = familias.get(j);
//				System.out.println("Asociando el familia " + familia + " a la promocion " + promocion );
				List<Promocion> listPromociones = new ArrayList<Promocion>();
				listPromociones.add(promocion);
				familia.setPromociones(listPromociones);
				familiaRepo.save(familia);
			}
		}
	}
	
	public void deleteAll() {
		List<Familia> familias = familiaRepo.findAll();
		for (Familia familia : familias) {
			List<Promocion> promocionesProd = familia.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				familia.setPromociones(Collections.<Promocion>emptyList());
				familiaRepo.save(familia);
			}
		}
	}
}
