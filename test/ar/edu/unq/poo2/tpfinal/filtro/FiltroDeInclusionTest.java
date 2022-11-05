package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroDeInclusionTest {
	public FiltroSimple fauna;
	public Proyecto animalesPeligrosos, floraAutoctona, faunaMarina;
	public String zoologia, botanica;
	public List<String> categories;
	public List<Proyecto> proyects; 
	
	@BeforeEach
	void setUp() throws Exception {
		proyects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = new Proyecto("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Proyecto("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyecto("Flora autoctona", "Proyecto sobre flores nativas");
		
		zoologia = "Zoología";
		botanica = "Botánica";
		categories = new ArrayList<String>();
		categories.add(zoologia);
		
		proyects.add(animalesPeligrosos);
		proyects.add(faunaMarina);
		proyects.add(floraAutoctona);
		
		animalesPeligrosos.vincularACategoria(zoologia);
		faunaMarina.vincularACategoria(zoologia);
		floraAutoctona.vincularACategoria(botanica);
		
		fauna = new FiltroDeInclusionCategorias(categories);
		
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
