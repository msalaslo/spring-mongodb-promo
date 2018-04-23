package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.MarcaRepository;
import com.msl.mongo.promo.repository.PromocionRepository;


@Component
public class MarcaPromocionRelationsLoader implements IRepositoryLoader{
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private PromocionRepository promocionRepo;
		
	public void sharePromocionesLoad() {
		List<Promocion> promociones = promocionRepo.findAll();
		List<Marca> marcas = marcaRepo.findAll();
		int numMarcas = marcas.size();
		int numPromociones = promociones.size();
		int section = numMarcas/numPromociones;		
		Promocion promocion = promociones.get(0);
		//Vamos avanzando la promociones a un conjunto equitativo de marcas
		for(int i = 0; i<numPromociones; i++) {
			promocion = promociones.get(i);
			int iniSection = i*section;
			int endSection = iniSection + section;
			for (int j = iniSection; j<endSection; j++) {			
				Marca marca = marcas.get(j);
//				System.out.println("Asociando el marca " + marca + " a la promocion " + promocion );
				List<Promocion> listPromociones = new ArrayList<Promocion>();
				listPromociones.add(promocion);
				marca.setPromociones(listPromociones);
				marcaRepo.save(marca);
			}
		}
	}
	
	public void deleteAll() {
		List<Marca> marcas = marcaRepo.findAll();
		for (Marca marca : marcas) {
			List<Promocion> promocionesProd = marca.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				marca.setPromociones(Collections.<Promocion>emptyList());
				marcaRepo.save(marca);
			}
		}
	}
}
