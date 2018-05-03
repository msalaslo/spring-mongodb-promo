package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.repository.ProductoRepository;

@Component
public class ProductoLoader implements IRepositoryLoader{
	
	Logger logger = LoggerFactory.getLogger(ProductoLoader.class.getName());

	@Autowired
	private ProductoRepository repository;
		
	@Override
	public void deleteAll() {
	    repository.deleteAll();
	}

	@Override
	public void load() {    
		saveProductos(RepositoryConfig.NUM_PRODUCTOS);
	}
	
	public static void printAllProductosByName(ProductoRepository repository) {
		System.out.println("## Return all productos sorted by name");
		Iterable<Producto> allSorted = repository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name")));
		allSorted.forEach(System.out::println);
	}

	private void saveProductos(int numProductos) {
//		int groups = numProductos/100;
		int groups = numProductos/numProductos;
		if(groups > 0) {
			for(int i=0;i<groups;i++) {
				logger.debug("Salvando " + numProductos + " productos");
				repository.saveAll(createProductos(i, numProductos));
			}
		}
	}

	private List<Producto> createProductos(int start, int numProductos) {
		logger.debug("Creando " + numProductos + " productos");
		List<Producto> productos = new ArrayList<Producto>();		
		for (int i = start; i < numProductos; i++) {
			String cempresa = String.format("%03d",Integer.valueOf(i));
			String centrooo = String.format("%04d",Integer.valueOf(i));
			String cdepartm = String.format("%04d",Integer.valueOf(i));
			String cfamilia = String.format("%03d",Integer.valueOf(i));
			String cbarraaa = String.format("%04d",Integer.valueOf(i));
			String ctallaec = String.format("%03d",Integer.valueOf(i));
			String cdivisio = String.format("%02d",Integer.valueOf(i));
			String cniveln = String.format("%01d",Integer.valueOf(i));
			String cfabrica = String.format("%06d",Integer.valueOf(i));
			String cmarmuma = String.format("%014d",Integer.valueOf(i));
			String referencia = cempresa + centrooo + cdepartm + cfamilia + cbarraaa + ctallaec + cdivisio + cniveln + cfabrica + cmarmuma;
			productos.add(new Producto(referencia + i , "producto" + i));
		}
	    return productos;
	}
}
