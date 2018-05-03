package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Marca;
import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.repository.MarcaRepository;
import com.msl.mongo.promo.repository.ProductoRepository;


@Component
public class ProductoMarcaRelationsLoader implements IRelacionableRepositoryLoader{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Override
	public void loadRelaciones() {
		List<Marca> marcas = marcaRepo.findAll();
		List<Producto> productos = productoRepo.findAll();
		int numProductos = productos.size();
		int numMarcas = marcas.size();
		int section = numProductos/numMarcas;		
		Marca marca = marcas.get(0);
		//Vamos avanzando la marcas para asignarlas a un conjunto equitativo de productos
		for(int i = 0; i<numMarcas; i++) {
			marca = marcas.get(i);
			int iniSection = i*section;
			int endSection = iniSection + section;
			for (int j = iniSection; j<endSection; j++) {			
				Producto producto = productos.get(j);
//				System.out.println("Asociando el producto " + producto + " a la marca " + marca );
				List<Marca> listMarcas = new ArrayList<Marca>();
				listMarcas.add(marca);
				producto.setMarcas(listMarcas);
				productoRepo.save(producto);
			}
		}
	}
	
	@Override
	public void deleteRelaciones() {
		List<Producto> productos = productoRepo.findAll();
		for (Producto producto : productos) {
			List<Marca> marcasProd = producto.getMarcas();
			if(marcasProd != null && !marcasProd.isEmpty()) {
				producto.setMarcas(Collections.<Marca>emptyList());
				productoRepo.save(producto);
			}
		}
	}
}
