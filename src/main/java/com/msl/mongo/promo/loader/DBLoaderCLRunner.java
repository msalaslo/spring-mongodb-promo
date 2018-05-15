package com.msl.mongo.promo.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.msl")
public class DBLoaderCLRunner implements CommandLineRunner {
	
	@Autowired
	EmpresaLoader empresaLoader;
	
	@Autowired
	CentroLoader centroLoader;
	
	@Autowired
	FamiliaLoader familiaLoader;

	@Autowired
	MarcaLoader marcaLoader;

	@Autowired
	ProductoLoader productoLoader;

	@Autowired
	PromocionLoader promocionLoader;
	
	@Autowired
	EmpresaPromocionRelationsLoader empresaPromocionLoader;
	
	@Autowired
	CentroPromocionRelationsLoader centroPromocionLoader;
	
	@Autowired
	MarcaPromocionRelationsLoader familiaPromocionLoader;
	
	@Autowired
	FamiliaPromocionRelationsLoader marcaPromocionLoader;
	
	@Autowired
	ProductoPromocionRelationsLoader productoPromocionLoader;
	
	@Autowired
	ProductoFamiliaRelationsLoader productoFamiliaLoader;
	
	@Autowired
	ProductoMarcaRelationsLoader productoMarcaLoader;
	
	@Override
	public void run(final String... args) throws Exception {
		IRepositoryLoader[] loaders = {empresaLoader, centroLoader, familiaLoader, marcaLoader, productoLoader, promocionLoader};
		IRelacionableRepositoryLoader[] relacionableLoaders = {productoFamiliaLoader, productoMarcaLoader};
		IPromocionableRepositoryLoader[] promocionLoaders = {empresaPromocionLoader, centroPromocionLoader, familiaPromocionLoader, marcaPromocionLoader, productoPromocionLoader};
		deleteRepositories(loaders);
		deletePromociones(promocionLoaders);
		deleteRelaciones(relacionableLoaders);
		loadRepositories(loaders);		
		loadPromociones(promocionLoaders);
		loadRelaciones(relacionableLoaders);
	}
	
	private void deleteRepositories(IRepositoryLoader[] loaders) {
		for (IRepositoryLoader loader : loaders) {
			System.out.println("Borrando datos sobre " + loader);
			loader.deleteAll();
		}
	}
	
	private void loadRepositories(IRepositoryLoader[] loaders) {
		for (IRepositoryLoader loader : loaders) {
			System.out.println("Cargando datos sobre " + loader);
			loader.load();
		}
	}
	
	private void deleteRelaciones(IRelacionableRepositoryLoader[] loaders) {
		for (IRelacionableRepositoryLoader loader : loaders) {
			System.out.println("Borrando relaciones sobre " + loader);
			loader.deleteRelaciones();
		}
	}
	
	private void loadRelaciones(IRelacionableRepositoryLoader[] loaders) {
		for (IRelacionableRepositoryLoader loader : loaders) {
			System.out.println("Cargando relaciones sobre " + loader);
			loader.loadRelaciones();
		}
	}
	
	private void deletePromociones(IPromocionableRepositoryLoader[] loaders) {
		for (IPromocionableRepositoryLoader loader : loaders) {
			System.out.println("Borrado promociones de " + loader);
			loader.deletePromociones();
		}
	}
	
	private void loadPromociones(IPromocionableRepositoryLoader[] loaders) {
		for (IPromocionableRepositoryLoader loader : loaders) {
			System.out.println("Cargando promociones sobre " + loader);
			loader.loadPromociones();
		}
	}
}
