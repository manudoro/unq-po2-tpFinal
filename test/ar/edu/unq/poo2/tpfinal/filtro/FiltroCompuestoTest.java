package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class FiltroCompuestoTest {
	
	public FiltroCompuesto disjunction;
	public Filtrable estrella, includesBot, exludesBot, includesAstBot, excludesZoo, nameBosque;
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public String zoologia,botanica, astronomia;
	public List<String> bot, astBot, zoo;
	public List<Proyecto> projects;
	public BusquedaDeDisyuncion disjunctionSearch;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		disjunctionSearch = new BusquedaDeDisyuncion();
		
		animalesPeligrosos = new Proyecto("Peligros del bosque", "Proyecto sobre animales");
		faunaMarina = new Proyecto("Ballena franca", "Proyecto sobre ballena franca");
		floraAutoctona = new Proyecto("Flora autoctona", "Proyecto sobre flores nativas");
		stars = new Proyecto("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia ="Zoología";
		botanica = "Botánica";
		astronomia = "Astronomia";
		
		bot = new ArrayList<String>();
		bot.add(botanica);
		
		astBot = new ArrayList<String>();
		astBot.add(botanica);
		astBot.add(astronomia);
		
		zoo = new ArrayList<String>();
		zoo.add(zoologia);
		
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		projects.add(stars);
		
		animalesPeligrosos.vincularACategoria(zoologia);
		faunaMarina.vincularACategoria(zoologia);
		floraAutoctona.vincularACategoria(botanica);
		stars.vincularACategoria(astronomia);
		
		estrella = new FiltroDeNombre("estrella", projects);
		includesBot = new FiltroDeInclusion(bot, projects);
		exludesBot = new FiltroDeExclusion(bot, projects);
		includesAstBot = new FiltroDeInclusion(astBot, projects);
		excludesZoo = new FiltroDeExclusion(zoo, projects);
		nameBosque = new FiltroDeNombre("Bosque", projects);

		disjunction = new FiltroCompuesto(disjunctionSearch);
	}

	@Test
	// Cuando se pide una disyuncion con un filtro de nombre y uno de inclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfNameAndIncludesCategories() {
		disjunction.agregarFiltro(estrella);
		disjunction.agregarFiltro(includesBot);
		List<Proyecto> results = disjunction.buscar();
		assertEquals(2, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfNameAndExcludesCategories() {
		disjunction.agregarFiltro(estrella);
		disjunction.agregarFiltro(exludesBot);
		List<Proyecto> results = disjunction.buscar();
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	@Test 
	// Cuando se pide una disyuncion con un filtro de inclusion y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfIncludesAndExcludesCategories() {
		disjunction.agregarFiltro(includesBot);
		disjunction.agregarFiltro(exludesBot);
		List<Proyecto> results = disjunction.buscar();
		assertEquals(4, results.size());

	}
	@Test
	void testDisjunctionOfIncludesExcludesCategoriesAndName() {
		@Test 
		// Cuando se pide una disyuncion con un filtro de nombre, uno de exclusion y uno de inclusion
		// de categorias se obtienen todos los que cumplen con los 3 criterios 
		disjunction.agregarFiltro(excludesZoo);
		disjunction.agregarFiltro(includesAstBot);
		disjunction.agregarFiltro(nameBosque);
		List<Proyecto> results = disjunction.buscar();
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));
	}
	

}