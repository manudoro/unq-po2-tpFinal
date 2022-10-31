package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeExclusion extends Filtro {
	private List<String> categories;
	private List<Proyecto> projects;

	public FiltroDeExclusion(List<String> categories, List<Proyecto> projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public List<Proyecto> buscar() {
		List<Proyecto> filteredProjects = projects.stream().
				filter(p -> this.excluyeTodas(p.getCategorias())).toList();
		return filteredProjects;
		
	}

	private boolean excluyeTodas(List<String> myCategories) {
		for(String c : myCategories) {
			if (categories.contains(c)){
				return false;
			}
		}
		return true;
	}

	public void agregarCategoria(String category) {
		categories.add(category);
		
	}

	public List<String> getCategorias() {
		return categories;
	}

	public void agregarProyecto(Proyecto project) {
		this.projects.add(project);
		
	}
	
	
	
}
