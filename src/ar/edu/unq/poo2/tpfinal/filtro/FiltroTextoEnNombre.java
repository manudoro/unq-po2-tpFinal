package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroTextoEnNombre implements Filtrable {
	private String searchText;
	private List<Proyecto> projects;
	
	public FiltroTextoEnNombre(String text, List<Proyecto> projects) {
		this.searchText = text;
		this.projects = projects;
	}

	public List<Proyecto> buscar() {
		List<Proyecto> filteredList = this.projects.stream().
				filter(p -> p.getNombre().toUpperCase().contains(searchText.toUpperCase())).toList();
		return filteredList;
	}

	public void setTexto(String newText) {
		this.searchText = newText;
		
	}
	@Override
	public Set<Proyecto> getProyectos() {
		
		HashSet<Proyecto> proyectos = new HashSet(projects);
		return proyectos;
	}
}
