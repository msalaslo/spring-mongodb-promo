package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Centro;
import com.msl.mongo.promo.repository.CentroRepository;

@Component
public class CentroLoader implements IRepositoryLoader{

	@Autowired
	private CentroRepository repository;
	
	@Override
	public void deleteAll() {
	    repository.deleteAll();
	}

	public void load() {    
	    List<Centro> createCentros = createCentros(RepositoryConfig.NUM_EMPRESAS);
	    repository.saveAll(createCentros);
	}
	
	private static List<Centro> createCentros(int numCentros) {
		String namePrefix = "centro";
		List<Centro> marcas = new ArrayList<Centro>();
		for(int ccentro = 0; ccentro < numCentros; ccentro++){
			String ccentroStr = String.format("%03d",Integer.valueOf(ccentro));
			Centro marca = new Centro(ccentroStr, namePrefix + ccentro);
			marcas.add(marca);
		}
	    return marcas;
	  }
}