package com.msl.mongo.promo.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.msl")
public class DBLoaderCLRunner implements CommandLineRunner {

	public static final int NUM_MARCAS = 100;
	public static final int NUM_PRODUCTOS = 1000;
	public static final int NUM_PROMOS = 10;

	@Autowired
	MarcaLoader marcaLoader;

	@Autowired
	ProductoLoader productoLoader;

	@Autowired
	PromocionLoader promocionLoader;
	
	@Override
	public void run(final String... args) throws Exception {
		System.out.println("Borrando base de datos");
		IRepositoryLoader[] loaders = {marcaLoader, productoLoader, promocionLoader};
		deleteRepositories(loaders);
		System.out.println("Cargando marcas:" + NUM_MARCAS);
		marcaLoader.load(NUM_MARCAS);
		System.out.println("Cargando productos:" + NUM_PRODUCTOS);
		productoLoader.load(NUM_PRODUCTOS);
		System.out.println("Cargando promociones:" + NUM_PROMOS);
		promocionLoader.load(NUM_PROMOS);
	}
	
	private void deleteRepositories(IRepositoryLoader[] loaders) {
		for (IRepositoryLoader loader : loaders) {
			loader.deleteAll();
		}
	}
}
