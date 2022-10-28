package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcludesFilterTest {
	public ExcludesFilter fauna;
	
	public Proyect faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public Category zoologia,botanica, astronomia;
	public List<Category> categories;
	public List<Proyect> proyects; 
	
	@BeforeEach
	void setUp() throws Exception {
		proyects = new ArrayList<Proyect>();
		
		animalesPeligrosos = new Proyect("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Proyect("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyect("Flora autoctona", "Proyecto sobre flores nativas");
		stars = new Proyect("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = new Category("Zoología");
		botanica = new Category("Botánica");
		astronomia = new Category("Astronomia");
		categories = new ArrayList<Category>();
		categories.add(zoologia);
		proyects.add(animalesPeligrosos);
		proyects.add(faunaMarina);
		proyects.add(floraAutoctona);
		
		animalesPeligrosos.addCategory(zoologia);
		faunaMarina.addCategory(zoologia);
		floraAutoctona.addCategory(botanica);
		stars.addCategory(astronomia);
		
		fauna = new ExcludesFilter(categories, proyects);
		
	}

	@Test
	void testExcludesFilterIncludesProyects() {
		List<Proyect> filterProyects = fauna.search();
		assertEquals(1, filterProyects.size());
		assertFalse(filterProyects.contains(animalesPeligrosos));
		assertFalse(filterProyects.contains(faunaMarina));
	}
	
	@Test
	void testExcludesFilterExcludesProyects() {
		List<Proyect> filterProyects = fauna.search();
		assertTrue(filterProyects.contains(floraAutoctona));
	}
	
	@Test 
	void testExcludesCanAddCategories() {
		fauna.addCategory(botanica);
		assertTrue(fauna.getCategories().contains(botanica));
	}
	
	@Test 
	void testExcludesFilterMustExcludesAll() {
		fauna.addCategory(botanica);
		List<Proyect> filterProyects = fauna.search();
		assertEquals(0, filterProyects.size());
	}
	
	@Test
	
	void testExludesFilterTheOtherwicthTheOderCategory() {
		fauna.addCategory(botanica);
		fauna.addProyect(stars);
		List<Proyect> filterProyects = fauna.search();
		assertEquals(1, filterProyects.size());
		assertTrue(filterProyects.contains(stars));

	}
	
	
	
}
