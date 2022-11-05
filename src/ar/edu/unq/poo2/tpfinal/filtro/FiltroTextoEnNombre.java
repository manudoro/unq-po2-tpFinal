package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroTextoEnNombre extends FiltroSimple implements Filtrable {
	private String searchText;
	
	public FiltroTextoEnNombre(String text, List<Proyecto> projects) {
		this.searchText = text;
		this.projects = projects;
	}

	protected List<Proyecto> recolectar() {
		List<Proyecto> filteredList = this.projects.stream().
				filter(p -> p.getNombre().toUpperCase().contains(searchText.toUpperCase())).toList();
		return filteredList;
	}

	public void setTexto(String newText) {
		this.searchText = newText;
		
	}

}
