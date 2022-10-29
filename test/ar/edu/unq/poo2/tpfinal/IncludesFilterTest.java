package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncludesFilterTest {
	public IncludesFilter fauna;
	public Project animalesPeligrosos;
	public Project floraAutoctona;
	public Project faunaMarina;
	public Category zoologia;
	public Category botanica;
	public List<Category> categories;
	public List<Project> proyects; 
	
	@BeforeEach
	void setUp() throws Exception {
		proyects = new ArrayList<Project>();
		
		animalesPeligrosos = new Project("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Project("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Project("Flora autoctona", "Proyecto sobre flores nativas");
		
		zoologia = new Category("Zoología");
		botanica = new Category("Botánica");
		categories = new ArrayList<Category>();
		categories.add(zoologia);
		
		proyects.add(animalesPeligrosos);
		proyects.add(faunaMarina);
		proyects.add(floraAutoctona);
		
		animalesPeligrosos.addCategory(zoologia);
		faunaMarina.addCategory(zoologia);
		floraAutoctona.addCategory(botanica);
		
		fauna = new IncludesFilter(categories, proyects);
		
	}

	@Test
	void testIncludesFilterIncludesProyects() {
		List<Project> filterProyects = fauna.search();
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(animalesPeligrosos));
		assertTrue(filterProyects.contains(faunaMarina));
	}
	
	@Test
	void testIncludesFilterExcludesProyects() {
		List<Project> filterProyects = fauna.search();
		assertFalse(filterProyects.contains(floraAutoctona));
	}
	
	@Test 
	void testIncludesCanAddCategories() {
		fauna.addCategory(botanica);
		assertTrue(fauna.getCategories().contains(botanica));
	}
	
	@Test 
	void testIncludesFilterMustIncludesAll() {
		fauna.addCategory(botanica);
		List<Project> filterProyects = fauna.search();
		assertTrue(filterProyects.size() == 0);		
	}
}