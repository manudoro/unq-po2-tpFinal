package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroTextoEnNombreTest {
	public FiltroTextoEnNombre flor;
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
		flor = new FiltroTextoEnNombre("Flor");
		
	}

	@Test
	// Cuando se busca por un determinado texto, se obtienen los proyectos que lo incluyen en su titulo
	void testNameFilterIncludesProjects() {
		List<Proyecto> filterProyects = flor.buscar(projects);
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(floresNativas));
		assertTrue(filterProyects.contains(floraAutoctona));
	}
	
	@Test
	// Cuando se busca por un determinado texto, no se obtienen los proyectos que no lo incluyen en su titulo
	void testNameFilterExcludesProjects() {
		List<Proyecto> filterProyects = flor.buscar(projects);
		assertFalse(filterProyects.contains(hojasSecas));
	}
}
