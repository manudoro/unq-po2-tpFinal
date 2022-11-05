package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeExclusion extends FiltroSimple implements Filtrable {
	private List<String> categories;
	
	public FiltroDeExclusion(List<String> categories, List<Proyecto> projects) {
		this.categories = categories;
		this.projects = projects;
	}
	
	public List<Proyecto> recolectar() {
		// este metodo permite obtener los proyectos de la lista que incluyen las categorias del filtro
		List<Proyecto> filteredProjects = projects.stream().
				filter(p -> p.excluyeCategorias(categories)).toList();
		return filteredProjects;
		
	}

	public void agregarCategoria(String category) {
		categories.add(category);
		
	}

	public List<String> getCategorias() {
		return categories;
	}




	
}
