package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroTextoEnNombreTest {
	public FiltroTextoEnNombre flor;
	public Proyecto floresNativas, floraAutoctona, hojasSecas;
	public List<Proyecto> projects; 
	public String florSt;

	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		florSt = "Flor";
		floresNativas = mock(Proyecto.class); 
		hojasSecas = mock(Proyecto.class);
		floraAutoctona = mock(Proyecto.class);
		when(floresNativas.contieneTextoEnNombre(florSt)).thenReturn(true);
		when(hojasSecas.contieneTextoEnNombre(florSt)).thenReturn(false);
		when(floraAutoctona.contieneTextoEnNombre(florSt)).thenReturn(true);
		projects.add(floresNativas);
		projects.add(hojasSecas);
		projects.add(floraAutoctona);
		flor = new FiltroTextoEnNombre(florSt);

		
	}

	@Test
	// Cuando se busca por un determinado texto, se obtienen los proyectos que lo incluyen en su titulo
	void testNameFilterIncludesProjects() {
		assertEquals(2, flor.buscar(projects).size());
		assertTrue(flor.buscar(projects).contains(floresNativas));
		assertTrue(flor.buscar(projects).contains(floraAutoctona));
	}
	
	@Test
	// Cuando se busca por un determinado texto, no se obtienen los proyectos que no lo incluyen en su titulo
	void testNameFilterExcludesProjects() {
		assertFalse(flor.buscar(projects).contains(hojasSecas));
	}
}
