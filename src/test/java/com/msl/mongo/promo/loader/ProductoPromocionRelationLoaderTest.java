package com.msl.mongo.promo.loader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoPromocionRelationLoaderTest {
	
	@Autowired
	ProductoPromocionRelationsLoader loader;

	@Before
	public void setUp() {
		loader.deletePromociones();
	}

	@Test
	public void loadRelations() {
		loader.loadPromociones();
	}
}