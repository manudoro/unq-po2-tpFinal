package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Categoria;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class NegacionDeFiltrosTest {
	public Filtrable disyuncion, conjuncion;
	public Filtrable negacionConjuncion, negacionDisyuncion, negacionExcluye, negacionEstrella, negacionIncluye, estrella, includesBot, excludesBot, includesAstBot, excludesZoo, nameBosque, excludesAst;
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public Categoria zoologia,botanica, astronomia;
	public List<Categoria> bot, astBot, zoo, ast;
	public List<Proyecto> projects;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = new Proyecto("Peligros del bosque", "Proyecto sobre animales");
		faunaMarina = new Proyecto("Ballena franca", "Proyecto sobre ballena franca");
		floraAutoctona = new Proyecto("Flora autoctona en bosques", "Proyecto sobre flores nativas");
		stars = new Proyecto("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia =new Categoria("Zoología");
		botanica = new Categoria("Botánica");
		astronomia = new Categoria("Astronomia");
		
		bot = new ArrayList<Categoria>();
		bot.add(botanica);
		
		astBot = new ArrayList<Categoria>();
		astBot.add(botanica);
		astBot.add(astronomia);
		
		zoo = new ArrayList<Categoria>();
		zoo.add(zoologia);
		
		ast = new ArrayList<Categoria>();
		ast.add(astronomia);
		
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
		excludesAst = new FiltroDeExclusionCategorias(ast);
		
		conjuncion = new ConjuncionDeFiltros(nameBosque, includesBot);

		disyuncion = new DisyuncionDeFiltros(estrella, includesBot);

		
		negacionEstrella = new NegacionDeFiltro(estrella);
		negacionIncluye = new NegacionDeFiltro(includesBot);
		negacionExcluye = new NegacionDeFiltro(excludesZoo);
		negacionConjuncion = new NegacionDeFiltro(conjuncion);
		negacionDisyuncion = new NegacionDeFiltro(disyuncion);
	}

	@Test
	// Cuando se pide una disyuncion con un filtro de nombre y uno de inclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testNegacionDeFiltroDInclusion() {
		List<Proyecto> results = negacionIncluye.buscar(projects);
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testNegacionDeFiltroDeTexto() {
		List<Proyecto> results = negacionEstrella.buscar(projects);
		assertEquals(3, results.size());
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));

	}
	
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testNegacionDeFiltroDeExclusion() {
		List<Proyecto> results = negacionExcluye.buscar(projects);
		assertEquals(2, results.size());
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));

	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de inclusion y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testNegacionDeDisyuncion() {
		List<Proyecto> results = negacionDisyuncion.buscar(projects);
		assertEquals(2, results.size());
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));

	}
	
	@Test
	void testNegacionDeConjuncion() {
		// Cuando se pide una disyuncion con un filtro de nombre, uno de exclusion y uno de inclusion
		// de categorias se obtienen todos los que cumplen con los 3 criterios 
		List<Proyecto> results = negacionConjuncion.buscar(projects);
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(animalesPeligrosos));
		assertTrue(results.contains(faunaMarina));
	}
}
	