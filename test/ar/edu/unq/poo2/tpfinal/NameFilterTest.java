package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameFilterTest {
	public NameFilter flor;
	public Proyect floresNativas;
	public Proyect floraAutoctona;
	public Proyect hojasSecas;
	public List<Proyect> proyects; 
	
	@BeforeEach
	void setUp() throws Exception {
		proyects = new ArrayList<Proyect>();
		floresNativas = new Proyect("Flores nativas", "Proyecto sobre flores nativas");
		hojasSecas = new Proyect("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyect("Flora autoctona", "Proyecto sobre flores nativas");
		proyects.add(floresNativas);
		proyects.add(hojasSecas);
		proyects.add(floraAutoctona);
		flor = new NameFilter("Flor", proyects);
		
	}

	@Test
	void testNameFilterIncludesProyects() {
		List<Proyect> filterProyects = flor.search();
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(floresNativas));
		assertTrue(filterProyects.contains(floraAutoctona));
	}
	
	@Test
	void testNameFilterExcludesProyects() {
		List<Proyect> filterProyects = flor.search();
		assertFalse(filterProyects.contains(hojasSecas));
	}

}
