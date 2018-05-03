package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.repository.EmpresaRepository;

@Component
public class EmpresaLoader implements IRepositoryLoader{

	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public void deleteAll() {
	    repository.deleteAll();
	}

	public void load() {    
	    List<Empresa> createEmpresas = createEmpresas(RepositoryConfig.NUM_EMPRESAS);
	    repository.saveAll(createEmpresas);
	}
	
	private static List<Empresa> createEmpresas(int numEmpresas) {
		String namePrefix = "empresa";
		List<Empresa> marcas = new ArrayList<Empresa>();
		for(int cempresa = 0; cempresa < numEmpresas; cempresa++){
			String cempresaStr = String.format("%03d",Integer.valueOf(cempresa));
			Empresa marca = new Empresa(cempresaStr, namePrefix + cempresa);
			marcas.add(marca);
		}
	    return marcas;
	  }
}