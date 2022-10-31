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
	
	public Project faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public String zoologia,botanica, astronomia;
	public List<String> categories;
	public List<Project> projects; 
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Project>();
		
		animalesPeligrosos = new Project("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Project("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Project("Flora autoctona", "Proyecto sobre flores nativas");
		stars = new Project("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = "Zoología";
		botanica = "Botánica";
		astronomia = "Astronomia";
		categories = new ArrayList<String>();
		categories.add(zoologia);
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		
		animalesPeligrosos.addCategory(zoologia);
		faunaMarina.addCategory(zoologia);
		floraAutoctona.addCategory(botanica);
		stars.addCategory(astronomia);
		
		fauna = new ExcludesFilter(categories, projects);
		
	}

	@Test
	void testExcludesFilterIncludesProjects() {
		List<Project> filterProjects = fauna.search();
		assertEquals(1, filterProjects.size());
		assertFalse(filterProjects.contains(animalesPeligrosos));
		assertFalse(filterProjects.contains(faunaMarina));
	}
	
	@Test
	void testExcludesFilterExcludesProjects() {
		List<Project> filterProjects = fauna.search();
		assertTrue(filterProjects.contains(floraAutoctona));
	}
	
	@Test 
	void testExcludesCanAddCategories() {
		fauna.addCategory(botanica);
		assertTrue(fauna.getCategories().contains(botanica));
	}
	
	@Test 
	void testExcludesFilterMustExcludesAll() {
		fauna.addCategory(botanica);
		List<Project> filterProjects = fauna.search();
		assertEquals(0, filterProjects.size());
	}
	
	@Test
	
	void testExludesFilterIncludesWithMoreCategories() {
		fauna.addCategory(botanica);
		fauna.addProject(stars);
		List<Project> filterProjects = fauna.search();
		assertEquals(1, filterProjects.size());
		assertTrue(filterProjects.contains(stars));

	}
	
	
	
}
