package ar.edu.unq.poo2.tpfinal.filtro;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeInclusion implements Filtrable {
	private List<String> categories;
	private List<Proyecto> projects;	


	public List<Proyecto> getProjects() {
		return projects;
	}


	public FiltroDeInclusion(List<String> categories, List<Proyecto> projects) {
		this.categories = categories;
		this.projects = projects;
	}


	public List<Proyecto> buscar() {
		// este metodo permite obtener los proyectos de la lista que excluyen las categorias del filtro

		List<Proyecto> filteredProjects = projects.
				stream().filter(p -> p.contieneCategorias(categories)).toList();
		return filteredProjects;
	}


	public void agregarCategoria(String category) {
		this.categories.add(category);
		
	}


	public List<String> getCategorias() {
		return categories;
	}

	@Override
	public Set<Proyecto> getProyectos() {
		
		HashSet<Proyecto> proyectos = new HashSet(projects);
		return proyectos;
	}
}

