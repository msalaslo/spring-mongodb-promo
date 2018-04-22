package com.msl.mongo.promo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msl.mongo.promo.entity.Producto;
import com.msl.mongo.promo.entity.Promocion;
import com.msl.mongo.promo.service.ProductoService;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	Logger logger = LoggerFactory.getLogger(ProductoController.class.getName());
	
	@Autowired
	ProductoService service;
	
//	@GetMapping(path = "/findByid")
//    public Producto findByid(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
//        logger.debug("Buscando producto por id...");
//        return service.findByid(id);
//    }
	
	@GetMapping(path = "/findByReferencia")
    public Iterable<Producto> findByReferencia(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Buscando producto por codpromoci...");
        return service.findByReferencia(referencia);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
        logger.debug("Buscando promociones por id...");
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByReferencia")
    public Iterable<Promocion> findPromocionesByReferencia(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Buscando promociones por referencia...");
        return service.findPromocionesByReferencia(referencia);
    }	
	
	@GetMapping(path = "/test")
    public Producto test(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Test...");
        return new Producto(referencia, "test");
    }
	
    @PostMapping(path = "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
    	Producto savedProduct = this.service.save(producto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}