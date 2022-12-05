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

class FiltroDeInclusionTest {
	public FiltroSimple fauna;
	public Proyecto animalesPeligrosos, floraAutoctona, faunaMarina;
	public Categoria zoologia, botanica;
	public List<Categoria> categories;
	public List<Proyecto> proyects; 
	public Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		proyects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = mock(Proyecto.class);
		faunaMarina = mock(Proyecto.class);
		floraAutoctona = mock(Proyecto.class);
		
		
		categories = new ArrayList<Categoria>();

		
		proyects.add(animalesPeligrosos);
		proyects.add(faunaMarina);
		proyects.add(floraAutoctona);
		
		when(animalesPeligrosos.contieneCategorias(categories)).thenReturn(true);
		when(faunaMarina.contieneCategorias(categories)).thenReturn(true);
		when(floraAutoctona.contieneCategorias(categories)).thenReturn(false);
		
		fauna = new FiltroDeInclusionCategorias(categories);
		
		sistema = new Sistema(proyects);
		
	}

	@Test
	// Cuando se incluye una categoria, se obtienen los proyectos que la tienen
	void testIncludesFilterIncludesProyects() {
		List<Proyecto> filterProyects = fauna.buscar(proyects);
		assertEquals(2, filterProyects.size());
		assertTrue(filterProyects.contains(animalesPeligrosos));
		assertTrue(filterProyects.contains(faunaMarina));
	}
	
	@Test
	// Cuando se incluye una categoria, no se obtienen los proyectos que no la tienen
	void testIncludesFilterExcludesProyects() {
		List<Proyecto> filterProyects = fauna.buscar(proyects);
		assertFalse(filterProyects.contains(floraAutoctona));
	}
	
}
