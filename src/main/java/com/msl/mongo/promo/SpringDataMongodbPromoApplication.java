package com.msl.mongo.promo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msl.mongo.promo.loader.DBLoaderCLRunner;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringDataMongodbPromoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringDataMongodbPromoApplication.class);
	public final static String name = "MongoDB Promo";
	
	public static void main(final String... args) {
		logger.info("Iniciando aplicacion" + name);
//		Object[] runner = new Object[] {DBLoaderCLRunner.class};
		SpringApplication.run(DBLoaderCLRunner.class, args);
//		SpringApplication.run(SpringDataMongodbPromoApplication.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
		logger.info("Aplicacion " + name + " iniciada");
	}
}