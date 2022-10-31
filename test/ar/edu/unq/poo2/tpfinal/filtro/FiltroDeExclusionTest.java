package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroDeExclusionTest {
	public FiltroDeExclusion fauna;
	
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public String zoologia,botanica, astronomia;
	public List<String> categories;
	public List<Proyecto> projects; 
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = new Proyecto("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Proyecto("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyecto("Flora autoctona", "Proyecto sobre flores nativas");
		stars = new Proyecto("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = "Zoología";
		botanica = "Botánica";
		astronomia = "Astronomia";
		categories = new ArrayList<String>();
		categories.add(zoologia);
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		
		animalesPeligrosos.vincularACategoria(zoologia);
		faunaMarina.vincularACategoria(zoologia);
		floraAutoctona.vincularACategoria(botanica);
		stars.vincularACategoria(astronomia);
		
		fauna = new FiltroDeExclusion(categories, projects);
		
	}

	@Test
	void testExcludesFilterIncludesProjects() {
		List<Proyecto> filterProjects = fauna.buscar();
		assertEquals(1, filterProjects.size());
		assertFalse(filterProjects.contains(animalesPeligrosos));
		assertFalse(filterProjects.contains(faunaMarina));
	}
	
	@Test
	void testExcludesFilterExcludesProjects() {
		List<Proyecto> filterProjects = fauna.buscar();
		assertTrue(filterProjects.contains(floraAutoctona));
	}
	
	@Test 
	void testExcludesCanAddCategories() {
		fauna.agregarCategoria(botanica);
		assertTrue(fauna.getCategorias().contains(botanica));
	}
	
	@Test 
	void testExcludesFilterMustExcludesAll() {
		fauna.agregarCategoria(botanica);
		List<Proyecto> filterProjects = fauna.buscar();
		assertEquals(0, filterProjects.size());
	}
	
	@Test
	
	void testExludesFilterIncludesWithMoreCategories() {
		fauna.agregarCategoria(botanica);
		fauna.agregarProyecto(stars);
		List<Proyecto> filterProjects = fauna.buscar();
		assertEquals(1, filterProjects.size());
		assertTrue(filterProjects.contains(stars));

	}
	
	
	
}
