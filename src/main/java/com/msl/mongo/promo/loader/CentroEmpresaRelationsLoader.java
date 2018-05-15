package com.msl.mongo.promo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Empresa;
import com.msl.mongo.promo.entity.Centro;
import com.msl.mongo.promo.entity.Relacionable;
import com.msl.mongo.promo.entity.RelacionableParent;
import com.msl.mongo.promo.entity.EntityUtils;
import com.msl.mongo.promo.repository.EmpresaRepository;
import com.msl.mongo.promo.repository.CentroRepository;


@Component
public class CentroEmpresaRelationsLoader extends AbstractRelacionableRepositoryLoader implements IRelacionableRepositoryLoader{
	
	@Autowired
	private CentroRepository centroRepo;
	
	@Autowired
	private EmpresaRepository empresaRepo;
		
	@Override
	public void loadRelaciones() {
		super.loadRelaciones(EntityUtils.toRelacionable(empresaRepo.findAll()), EntityUtils.toRelacionableParent(centroRepo.findAll()));
	}
	
	@Override
	public void deleteRelaciones() {
		List<Centro> centros = centroRepo.findAll();
		for (Centro centro : centros) {
			Empresa empresasProd = centro.getEmpresa();
			if(empresasProd != null) {
				centro.setEmpresa(null);
				centroRepo.save(centro);
			}
		}
	}

	@Override
	public void save(Relacionable relacionable, RelacionableParent parent) {
		Centro centro = (Centro)relacionable;
		centro.setEmpresa((Empresa)parent);
		centroRepo.save(centro);
	}
}
