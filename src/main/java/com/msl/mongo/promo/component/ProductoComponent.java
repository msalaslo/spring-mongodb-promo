package com.msl.mongo.promo.component;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.repository.ProductoRepository;

@Component
public class ProductoComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoComponent.class.getName());
	public static final String PATH = "c:/temp/references.txt";
	
	@Autowired
	ProductoRepository repository;
	
	public void generateReferencesFile(int numIDs) {
		// Get the file reference
		Path path = Paths.get(PATH);
		log("Generando fichero de " + numIDs + " REFERENCIAS en la ruta:" + path.toAbsolutePath());
		// Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {			
			Stream<Producto> productos = repository.streamAll();
					
				writer.write(UUID.randomUUID().toString() + "\r\n");
			
		} catch (Exception e) {
			logError("Error generando fichero de IDs", e);
		}
		log("Fichero generado correctamente.");
	}
	
	private static void log(String msg) {
		logger.info(msg);
		System.out.println(msg);
	}
	
	private static void logError(String msg, Exception e) {
		logger.error(msg, e);
		System.out.println(msg);
		e.printStackTrace();
	}

}
