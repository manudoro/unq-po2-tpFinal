package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroDeNombreTest {
	public FiltroDeNombre flor;
	public Proyecto floresNativas, floraAutoctona, hojasSecas;
	public List<Proyecto> projects; 
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		floresNativas = new Proyecto("Flores nativas", "Proyecto sobre flores nativas");
		hojasSecas = new Proyecto("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyecto("Flora autoctona", "Proyecto sobre flores nativas");
		projects.add(floresNativas);
		projects.add(hojasSecas);
		projects.add(floraAutoctona);
		flor = new FiltroDeNombre("Flor", projects);
		
	}

	@Test
	void testNameFilterIncludesProjects() {
		List<Proyecto> filterProyects = flor.buscar();
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(floresNativas));
		assertTrue(filterProyects.contains(floraAutoctona));
	}
	
	@Test
	void testNameFilterExcludesProjects() {
		List<Proyecto> filterProyects = flor.buscar();
		assertFalse(filterProyects.contains(hojasSecas));
	}
	
	@Test 
	void testNameFilterCaseInsensitive() {
		flor.setTexto("FLOR");
		List<Proyecto> filterProyects = flor.buscar();
		assertTrue(filterProyects.size() == 2);		
	}

}