package ar.edu.unq.poo2.tpfinal;

import java.util.List;

public class NameFilter extends Filter {
	private String searchText;
	private List<Proyect> proyects;
	
	public NameFilter(String text, List<Proyect> proyects) {
		this.searchText = text;
		this.proyects = proyects;
	}

	public List<Proyect> search() {
		List<Proyect> filteredList = this.proyects.stream().
				filter(p -> p.getName().toUpperCase().contains(searchText.toUpperCase())).toList();
		return filteredList;
	}

	public void setText(String newText) {
		this.searchText = newText;
		
	}
}
