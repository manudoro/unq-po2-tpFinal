package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroDeInclusionTest {
	public FiltroDeInclusion fauna;
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
		
		fauna = new FiltroDeInclusion(categories, proyects);
		
	}

	@Test
	void testIncludesFilterIncludesProyects() {
		List<Proyecto> filterProyects = fauna.buscar();
		assertTrue(filterProyects.size() == 2);
		assertTrue(filterProyects.contains(animalesPeligrosos));
		assertTrue(filterProyects.contains(faunaMarina));
	}
	
	@Test
	void testIncludesFilterExcludesProyects() {
		List<Proyecto> filterProyects = fauna.buscar();
		assertFalse(filterProyects.contains(floraAutoctona));
	}
	
	@Test 
	void testIncludesCanAddCategories() {
		fauna.agregarCategoria(botanica);
		assertTrue(fauna.getCategorias().contains(botanica));
	}
	
	@Test 
	void testIncludesFilterMustIncludesAll() {
		fauna.agregarCategoria(botanica);
		List<Proyecto> filterProyects = fauna.buscar();
		assertTrue(filterProyects.size() == 0);		
	}
}