package ar.edu.unq.poo2.tpfinal.filtro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.proyecto.Categoria;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.sistema.Sistema;

class ConjuncionDeFiltrosTest {
	public ConjuncionDeFiltros bosqueBot, bosqueNoAst, botNoAst, astBotEstrella, noZooABE;
	public Filtrable estrella, includesBot, excludesBot, includesAstBot, excludesZoo, nameBosque, excludesAst;
	public Proyecto faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public Categoria zoologia,botanica, astronomia;
	public List<Categoria> bot, astBot, zoo, ast;
	public List<Proyecto> projects;
	public Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Proyecto>();
		
		animalesPeligrosos = new Proyecto("Peligros del bosque", "Proyecto sobre animales");
		faunaMarina = new Proyecto("Ballena franca", "Proyecto sobre ballena franca");
		floraAutoctona = new Proyecto("Flora autoctona en bosques", "Proyecto sobre flores nativas");
		stars = new Proyecto("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = new Categoria("Zoología");
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
		
		bosqueBot = new ConjuncionDeFiltros(nameBosque, includesBot);
		bosqueNoAst = new ConjuncionDeFiltros(nameBosque, excludesAst);
		botNoAst = new ConjuncionDeFiltros(includesBot, includesBot);
		astBotEstrella = new ConjuncionDeFiltros(nameBosque, excludesAst);
		noZooABE = new ConjuncionDeFiltros(excludesZoo, astBotEstrella);
		
		sistema = new Sistema(projects);
	}

	@Test
	// Cuando se pide una disyuncion con un filtro de nombre y uno de inclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeFiltroDeTextoEInclusion() {
		List<Proyecto> results = sistema.buscarProyectos(bosqueBot);
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de nombre y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeFiltroDeTextoYExclusion() {
		List<Proyecto> results = sistema.buscarProyectos(bosqueNoAst);
		assertEquals(2, results.size());
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	// Cuando se pide una disyuncion con un filtro de inclusion y uno de exclusion de categorias, se obtienen todos
	// los que cumplen con ambos criterios 
	void testConjuncionDeInclusionYExclusion() {

		List<Proyecto> results = sistema.buscarProyectos(botNoAst);
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));

	}
	
	@Test
	void testConjuncionDeInclusionExclusionYTextoEnNombre() {
		// Cuando se pide una disyuncion con un filtro de nombre, uno de exclusion y uno de inclusion
		// de categorias se obtienen todos los que cumplen con los 3 criterios 
		List<Proyecto> results = sistema.buscarProyectos(noZooABE);
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));
;
	}
	
}
