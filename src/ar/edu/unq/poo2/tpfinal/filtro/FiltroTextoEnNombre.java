package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroTextoEnNombre implements Filtrable {
	private String searchText;
	private List<Proyecto> proyectos;

	
	public FiltroTextoEnNombre(String text, List<Proyecto> projects) {
		this.searchText = text;
		this.proyectos = projects;
	}

	public List<Proyecto> buscar() {
		List<Proyecto> filteredList = this.proyectos.stream().
				filter(p -> p.getNombre().toUpperCase().contains(searchText.toUpperCase())).toList();
		return filteredList;
	}

	@Override
	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

}
