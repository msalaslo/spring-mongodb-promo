package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.repository.MarcaRepository;

@Component
public class MarcaLoader implements IRepositoryLoader{

	@Autowired
	private MarcaRepository repository;
	
	@Override
	public void deleteAll() {
	    repository.deleteAll();
	}

	@Override
	public void load() {    
	    List<Marca> createMarcas = createMarcas(RepositoryConfig.NUM_MARCAS);
//	    System.out.println(String.format("Save %s additional marcas", numMarcas));
	    repository.saveAll(createMarcas);
	}
	
	public static void printAllMarcasByName(MarcaRepository repository) {
		System.out.println("## Return all marcas sorted by name");
		Iterable<Marca> allSorted = repository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name")));
		allSorted.forEach(System.out::println);
	}
	
	private static List<Marca> createMarcas(int numMarcas) {
		String namePrefix = "marca";
		List<Marca> marcas = new ArrayList<Marca>();
		for(int cmarmuma = 0; cmarmuma < numMarcas; cmarmuma++){
			String cmarmumaStr = String.format("%014d",Integer.valueOf(cmarmuma));
			Marca marca = new Marca(cmarmumaStr, namePrefix + cmarmuma);
			marcas.add(marca);
		}
	    return marcas;
	  }
}
