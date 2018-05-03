package com.msl.mongo.promo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msl.mongo.promo.loader.DBLoaderCLRunner;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringDataMongodbPromoApplication {
	public static void main(final String... args) {
//		Object[] runner = new Object[] {DBLoaderCLRunner.class};

//		SpringApplication.run(DBLoaderCLRunner.class, args);
		SpringApplication.run(SpringDataMongodbPromoApplication.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));

	}
}