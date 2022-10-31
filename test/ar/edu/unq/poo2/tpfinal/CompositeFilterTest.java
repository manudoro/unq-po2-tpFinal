package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.filtro.IMetodoDeBusqueda;
import ar.edu.unq.poo2.tpfinal.filtro.MetodoDeConjuncion;
import ar.edu.unq.poo2.tpfinal.filtro.MetodoDeDisyuncion;

class CompositeFilterTest {
	
	public CompositeFilter disjunction, conjunction;
	public Filter estrella, includesBot, exludesBot, includesAstBot, excludesZoo, nameBosque;
	public Project faunaMarina , stars ,animalesPeligrosos,floraAutoctona;
	public Category zoologia,botanica, astronomia;
	public List<Category> bot, astBot, zoo;
	public List<Project> projects;
	public IMetodoDeBusqueda disjunctionSearch, conjunctionSearch;
	
	
	@BeforeEach
	void setUp() throws Exception {
		projects = new ArrayList<Project>();
		disjunctionSearch = new MetodoDeDisyuncion();
		conjunctionSearch = new MetodoDeConjuncion();
		
		animalesPeligrosos = new Project("Peligros del bosque", "Proyecto sobre animales");
		faunaMarina = new Project("Ballena franca", "Proyecto sobre ballena franca");
		floraAutoctona = new Project("Bosque autoctono", "Proyecto sobre flores nativas");
		stars = new Project("Estrellas", "Proyecto sobre estrellas grandes");
		
		zoologia = new Category("Zoología");
		botanica = new Category("Botánica");
		astronomia = new Category("Astronomia");
		
		bot = new ArrayList<Category>();
		bot.add(botanica);
		
		astBot = new ArrayList<Category>();
		astBot.add(botanica);
		astBot.add(astronomia);
		
		zoo = new ArrayList<Category>();
		zoo.add(zoologia);
		
		projects.add(animalesPeligrosos);
		projects.add(faunaMarina);
		projects.add(floraAutoctona);
		projects.add(stars);
		
		animalesPeligrosos.addCategory(zoologia);
		faunaMarina.addCategory(zoologia);
		floraAutoctona.addCategory(botanica);
		stars.addCategory(astronomia);
		
		estrella = new NameFilter("estrella", projects);
		includesBot = new IncludesFilter(bot, projects);
		exludesBot = new ExcludesFilter(bot, projects);
		includesAstBot = new IncludesFilter(astBot, projects);
		excludesZoo = new ExcludesFilter(zoo, projects);
		nameBosque = new NameFilter("Bosque", projects);

		disjunction = new CompositeFilter(disjunctionSearch);
		conjunction = new CompositeFilter(conjunctionSearch);
	}

	@Test
	void testDisjunctionOfNameAndIncludesCategories() {
		disjunction.addFilter(estrella);
		disjunction.addFilter(includesBot);
		List<Project> results = disjunction.search();
		assertEquals(2, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
	}
	
	@Test 
	void testDisjunctionOfNameAndExcludesCategories() {
		disjunction.addFilter(estrella);
		disjunction.addFilter(exludesBot);
		List<Project> results = disjunction.search();
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(faunaMarina));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test 
	void testDisjunctionOfIncludesAndExcludesCategories() {
		disjunction.addFilter(includesBot);
		disjunction.addFilter(exludesBot);
		List<Project> results = disjunction.search();
		assertEquals(4, results.size());

	}
	@Test
	void testDisjunctionOfIncludesExcludesCategoriesAndName() {
		
		disjunction.addFilter(excludesZoo);
		disjunction.addFilter(includesAstBot);
		disjunction.addFilter(nameBosque);
		List<Project> results = disjunction.search();
		assertEquals(3, results.size());
		assertTrue(results.contains(stars));
		assertTrue(results.contains(floraAutoctona));
		assertTrue(results.contains(animalesPeligrosos));
	}
	
	@Test
	void testConjunctionOfNameAndIncludesCategories() {
		conjunction.addFilter(nameBosque);
		conjunction.addFilter(includesBot);
		List<Project> results = conjunction.search();
		assertEquals(1, results.size());
		assertTrue(results.contains(floraAutoctona));
	}

}
