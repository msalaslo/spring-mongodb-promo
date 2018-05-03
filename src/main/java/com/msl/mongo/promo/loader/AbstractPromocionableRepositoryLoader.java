package com.msl.mongo.promo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.entity.Promocionable;
import com.msl.mongo.promo.repository.PromocionRepository;

public abstract class AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader {
	
	@Autowired
	private PromocionRepository promocionRepo;
	
	@Override
	public void loadPromociones(List<Promocionable> promocionables) {
		// first create some relations for the marcas and promociones		
		List<Promocion> promociones = promocionRepo.findAll();
		int numPromociones = promociones.size();
		int numPromocionables = promocionables.size();
		int section = numPromocionables/numPromociones;
		int cont = 0;
		int promoIndex = 0;
		Promocion promocion = promociones.get(promoIndex);
		for (Promocionable promocionable : promocionables) {			
			//Vamos asociando los promocionables a un conjunto equitativo de promociones
			if(cont <= section && promoIndex <= numPromociones) {
				promocion = promociones.get(promoIndex);
				cont = 0;
			}else {
				cont++;
			}			
//			System.out.println("Asociando la promocion " + promocion + " al promocionable " + promocionable );
			this.save(promocionable, promocion);
			promoIndex++;
		}				
	}
	
	public void save(Promocionable promocionable, Promocion promocion) {
		List<Promocion> promociones = promocionable.getPromociones();
		promociones.add(promocion);
		promocionable.setPromociones(promociones);
		this.saveCasting((Producto)promocionable);
	}
	
	public abstract void saveCasting(Promocionable promocionable);

}
