package com.msl.mongo.promo.loader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarcaFamiliaRelationLoaderTest {
	
	@Autowired
	ProductoFamiliaRelationsLoader loader;

	@Before
	public void setUp() {
		loader.deleteRelaciones();
	}

	@Test
	public void loadRelations() {
		loader.loadRelaciones();
	}
}