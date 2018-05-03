package com.msl.mongo.promo.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.msl")
public class DBLoaderCLRunner implements CommandLineRunner {
	
	@Autowired
	EmpresaLoader empresaLoader;
	
	@Autowired
	MarcaLoader familiaLoader;

	@Autowired
	MarcaLoader marcaLoader;

	@Autowired
	ProductoLoader productoLoader;

	@Autowired
	PromocionLoader promocionLoader;
	
	@Autowired
	EmpresaPromocionRelationsLoader empresaPromocionLoader;
	
	@Autowired
	MarcaPromocionRelationsLoader marcaPromocionLoader;
	
	@Autowired
	ProductoPromocionRelationsLoader productoPromocionLoader;
	
	@Autowired
	MarcaFamiliaRelationsLoader marcaFamiliaLoader;
	
	@Autowired
	ProductoMarcaRelationsLoader productoMarcaLoader;
	
	@Override
	public void run(final String... args) throws Exception {
		IRepositoryLoader[] loaders = {empresaLoader, marcaLoader, productoLoader, promocionLoader};
		IRelacionableRepositoryLoader[] relacionableLoaders = {marcaFamiliaLoader, productoMarcaLoader};
		IPromocionableRepositoryLoader[] promocionLoaders = {empresaPromocionLoader, marcaPromocionLoader, productoPromocionLoader};
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
