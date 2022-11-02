package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeNombre implements Filtrable {
	private String searchText;
	private List<Proyecto> projects;
	
	public FiltroDeNombre(String text, List<Proyecto> projects) {
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
	
	public Filtrable negar() {
		List<Proyecto> proyectos = projects;
		proyectos.removeAll(this.buscar());
		return new FiltroDeNombre("", proyectos);
		
		
	}
}
