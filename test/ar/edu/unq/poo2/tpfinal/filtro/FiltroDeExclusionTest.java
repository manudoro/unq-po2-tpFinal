package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		
		animalesPeligrosos = new Proyecto("Flores nativas", "Proyecto sobre flores nativas");
		faunaMarina = new Proyecto("Hojas secas", "Proyecto sobre hojas secas");
		floraAutoctona = new Proyecto("Flora autoctona", "Proyecto sobre flores nativas");
		stars = new Proyecto("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = new Categoria("Zoología");
		botanica = new Categoria("Botánica");
		astronomia = new Categoria("Astronomia");
		categories = new ArrayList<Categoria>();
		categories.add(zoologia);
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		
		animalesPeligrosos.vincularACategoria(zoologia);
		faunaMarina.vincularACategoria(zoologia);
		floraAutoctona.vincularACategoria(botanica);
		stars.vincularACategoria(astronomia);
		
		fauna = new FiltroDeExclusionCategorias(categories);
		
		sistema = new Sistema(projects);
	}

	@Test
	// Cuando se excluye una categoria, se obtienen los proyectos que no la tienen
	void testExcludesFilterIncludesProjects() {
		List<Proyecto> filterProjects = sistema.buscarProyectos(fauna);
		assertEquals(1, filterProjects.size());
		assertFalse(filterProjects.contains(animalesPeligrosos));
		assertFalse(filterProjects.contains(faunaMarina));
	}
	// Cuando se excluye una categoria, no se obtienen los proyectos que la tienen

	@Test
	void testExcludesFilterExcludesProjects() {
		List<Proyecto> filterProjects = sistema.buscarProyectos(fauna);
		assertTrue(filterProjects.contains(floraAutoctona));
	}
	

	
	
	
}
