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

import ar.edu.unq.poo2.tpfinal.proyecto.Categoria;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroDeExclusionTest {
	public FiltroSimple fauna;
	
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public Categoria zoologia,botanica, astronomia;
	public List<Categoria> categories;
	public List<Proyecto> projects; 
	public Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = mock(Proyecto.class);
		faunaMarina = mock(Proyecto.class);
		floraAutoctona = mock(Proyecto.class);
		stars = mock(Proyecto.class);
		

		when(animalesPeligrosos.contieneCategorias(categories)).thenReturn(true);
		when(faunaMarina.contieneCategorias(categories)).thenReturn(true);
		when(floraAutoctona.contieneCategorias(categories)).thenReturn(false);

		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		

		
		fauna = new FiltroDeExclusionCategorias(categories);
		
		sistema = new Sistema(projects);
	}

	@Test
	// Cuando se excluye una categoria, se obtienen los proyectos que no la tienen
	void testExcludesFilterIncludesProjects() {
		List<Proyecto> filterProjects = fauna.buscar(projects);
		assertEquals(1, filterProjects.size());
		assertFalse(filterProjects.contains(animalesPeligrosos));
		assertFalse(filterProjects.contains(faunaMarina));
	}
	// Cuando se excluye una categoria, no se obtienen los proyectos que la tienen

	@Test
	void testExcludesFilterExcludesProjects() {
		List<Proyecto> filterProjects = fauna.buscar(projects);
		assertTrue(filterProjects.contains(floraAutoctona));
	}
	

	
	
	
}
