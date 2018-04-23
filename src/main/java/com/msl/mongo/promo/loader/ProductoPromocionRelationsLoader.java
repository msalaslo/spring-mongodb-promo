package com.msl.mongo.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.repository.ProductoRepository;
import com.msl.mongo.promo.repository.PromocionRepository;


@Component
public class ProductoPromocionRelationsLoader implements IRepositoryLoader{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private PromocionRepository promocionRepo;
		
	public void sharePromocionesLoad() {
		List<Promocion> promociones = promocionRepo.findAll();
		List<Producto> productos = productoRepo.findAll();
		int numProductos = productos.size();
		int numPromociones = promociones.size();
		int section = numProductos/numPromociones;		
		Promocion promocion = promociones.get(0);
		//Vamos avanzando la promociones a un conjunto equitativo de productos
		for(int i = 0; i<numPromociones; i++) {
			promocion = promociones.get(i);
			int iniSection = i*section;
			int endSection = iniSection + section;
			for (int j = iniSection; j<endSection; j++) {			
				Producto producto = productos.get(j);
//				System.out.println("Asociando el producto " + producto + " a la promocion " + promocion );
				List<Promocion> listPromociones = new ArrayList<Promocion>();
				listPromociones.add(promocion);
				producto.setPromociones(listPromociones);
				productoRepo.save(producto);
			}
		}
	}
	
	public void deleteAll() {
		List<Producto> productos = productoRepo.findAll();
		for (Producto producto : productos) {
			List<Promocion> promocionesProd = producto.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				producto.setPromociones(Collections.<Promocion>emptyList());
				productoRepo.save(producto);
			}
		}
	}
}
