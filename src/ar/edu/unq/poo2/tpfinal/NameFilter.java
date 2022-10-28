package ar.edu.unq.poo2.tpfinal;

import java.util.List;

public class NameFilter extends Filter {
	private String searchName;
	private List<Proyect> proyects;
	
	public NameFilter(String name, List<Proyect> proyects) {
		this.searchName = name;
		this.proyects = proyects;
	}

	public List<Proyect> search() {
		List<Proyect> filteredList = this.proyects.stream().
				filter(p -> p.getName().contains(searchName)).toList();
		return filteredList;
	}
}
