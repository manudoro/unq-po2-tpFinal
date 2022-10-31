package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameFilterTest {
	public NameFilter flor;
	public Project floresNativas, floraAutoctona, hojasSecas;
	public List<Project> projects; 
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Project>();
		floresNativas = new Project("Flores nativas", "Proyecto sobre flores nativas");
		hojasSecas = new Project("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Project("Flora autoctona", "Proyecto sobre flores nativas");
		projects.add(floresNativas);
		projects.add(hojasSecas);
		projects.add(floraAutoctona);
		flor = new NameFilter("Flor", projects);
		
	}

	@Test
	void testNameFilterIncludesProjects() {
		List<Project> filterProyects = flor.search();
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(floresNativas));
		assertTrue(filterProyects.contains(floraAutoctona));
	}
	
	@Test
	void testNameFilterExcludesProjects() {
		List<Project> filterProyects = flor.search();
		assertFalse(filterProyects.contains(hojasSecas));
	}
	
	@Test 
	void testNameFilterCaseInsensitive() {
		flor.setText("FLOR");
		List<Project> filterProyects = flor.search();
		assertTrue(filterProyects.size() == 2);		
	}

}
