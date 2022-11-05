package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class ConjuncionDeFiltrosTest {
	public ConjuncionDeFiltros bosqueBot, bosqueNoAst, botNoAst, astBotEstrella, noZooABE;
	public Filtrable estrella, includesBot, excludesBot, includesAstBot, excludesZoo, nameBosque, excludesAst;
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public String zoologia,botanica, astronomia;
	public List<String> bot, astBot, zoo, ast;
	public List<Proyecto> projects;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = new Proyecto("Peligros del bosque", "Proyecto sobre animales");
		faunaMarina = new Proyecto("Ballena franca", "Proyecto sobre ballena franca");
		floraAutoctona = new Proyecto("Flora autoctona en bosques", "Proyecto sobre flores nativas");
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
		
		ast = new ArrayList<String>();
		ast.add(astronomia);
		
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		projects.add(stars);
		
		animalesPeligrosos.vincularACategoria(zoologia);
		faunaMarina.vincularACategoria(zoologia);
		floraAutoctona.vincularACategoria(botanica);
		stars.vincularACategoria(astronomia);
		
		estrella = new FiltroTextoEnNombre   ("estrella", projects);
		includesBot = new FiltroDeInclusionCategorias   (bot, projects);
		excludesBot = new FiltroDeExclusionCategorias    (bot, projects);
		includesAstBot = new FiltroDeInclusionCategorias(astBot, projects);
		excludesZoo = new FiltroDeExclusionCategorias   (zoo, projects);
		nameBosque = new FiltroTextoEnNombre ("Bosque", projects);
		excludesAst = new FiltroDeExclusionCategorias(ast, projects);
		
		bosqueBot = new ConjuncionDeFiltros(nameBosque, includesBot);
		bosqueNoAst = new ConjuncionDeFiltros(nameBosque, excludesAst);
		botNoAst = new ConjuncionDeFiltros(includesBot, includesBot);
		astBotEstrella = new ConjuncionDeFiltros(nameBosque, excludesAst);
		noZooABE = new ConjuncionDeFiltros(excludesZoo, astBotEstrella);
		
	}

	@Test
	// Cuando se pide una disyuncion con un filtro de nombre y uno de inclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeFiltroDeTextoEInclusion() {
		List<Proyecto> results = bosqueBot.buscar();
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeFiltroDeTextoYExclusion() {
		List<Proyecto> results = bosqueNoAst.buscar();
		assertEquals(2, results.size());
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de inclusion y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeInclusionYExclusion() {

		List<Proyecto> results = botNoAst.buscar();
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));

	}
	
	@Test
	void testConjuncionDeInclusionExclusionYTextoEnNombre() {
		// Cuando se pide una disyuncion con un filtro de nombre, uno de exclusion y uno de inclusion
		// de categorias se obtienen todos los que cumplen con los 3 criterios 
		List<Proyecto> results = noZooABE.buscar();
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));
;
	}
	
}
