package com.msl.mongo.promo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.EntityUtils;
import com.msl.mongo.promo.entity.Familia;
import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Relacionable;
import com.msl.mongo.promo.entity.RelacionableParent;
import com.msl.mongo.promo.repository.FamiliaRepository;
import com.msl.mongo.promo.repository.ProductoRepository;


@Component
public class ProductoFamiliaRelationsLoader extends AbstractRelacionableRepositoryLoader implements IRelacionableRepositoryLoader{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private FamiliaRepository familiaRepo;
		
	@Override
	public void loadRelaciones() {
		super.loadRelaciones(EntityUtils.toRelacionable(productoRepo.findAll()), EntityUtils.toRelacionableParent(familiaRepo.findAll()));
	}
	
	@Override
	public void deleteRelaciones() {
		List<Producto> productos = productoRepo.findAll();
		for (Producto producto : productos) {
			Familia familiasProd = producto.getFamilia();
			if(familiasProd != null) {
				producto.setFamilia(null);
				productoRepo.save(producto);
			}
		}
	}

	@Override
	public void save(Relacionable relacionable, RelacionableParent parent) {
		Producto producto = (Producto)relacionable;
		producto.setFamilia((Familia)parent);
		productoRepo.save(producto);
	}
}
