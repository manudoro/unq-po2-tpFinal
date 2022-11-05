package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class DisyuncionDeFiltrosTest {
	
	public DisyuncionDeFiltros estrellaBot, estrellaNoBot, botNoBot, noZooAstBot, bosqueNoZAB;
	public Filtrable estrella, includesBot, excludesBot, includesAstBot, excludesZoo, nameBosque;
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public String zoologia,botanica, astronomia;
	public List<String> bot, astBot, zoo;
	public List<Proyecto> projects;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
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
		
		estrella = new FiltroTextoEnNombre   ("estrella");
		includesBot = new FiltroDeInclusionCategorias   (bot);
		excludesBot = new FiltroDeExclusionCategorias    (bot);
		includesAstBot = new FiltroDeInclusionCategorias(astBot);
		excludesZoo = new FiltroDeExclusionCategorias   (zoo);
		nameBosque = new FiltroTextoEnNombre ("Bosque");

		estrellaBot = new DisyuncionDeFiltros(estrella, includesBot);
		estrellaNoBot = new DisyuncionDeFiltros(estrella, excludesBot);
		botNoBot = new DisyuncionDeFiltros(includesBot, excludesBot);
		noZooAstBot = new DisyuncionDeFiltros(excludesZoo, includesAstBot);
		bosqueNoZAB = new DisyuncionDeFiltros(nameBosque, noZooAstBot);
		
	}

	@Test
	// Cuando se pide una disyuncion con un filtro de nombre y uno de inclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfNameAndIncludesCategories() {
		List<Proyecto> results = estrellaBot.buscar(projects);
		assertEquals(2, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfNameAndExcludesCategories() {
		List<Proyecto> results = estrellaNoBot.buscar(projects);
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de inclusion y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testDisjunctionOfIncludesAndExcludesCategories() {
		List<Proyecto> results = botNoBot.buscar(projects);
		assertEquals(4, results.size());

	}
	
	@Test
	void testDisjunctionOfIncludesExcludesCategoriesAndName() {
		// Cuando se pide una disyuncion con un filtro de nombre, uno de exclusion y uno de inclusion
		// de categorias se obtienen todos los que cumplen con los 3 criterios 
		List<Proyecto> results = bosqueNoZAB.buscar(projects);
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	

}