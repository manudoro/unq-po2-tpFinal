package ar.edu.unq.poo2.tpfinal;

import java.util.List;

public class NameFilter extends Filter {
	private String searchText;
	private List<Project> projects;
	
	public NameFilter(String text, List<Project> projects) {
		this.searchText = text;
		this.projects = projects;
	}

	public List<Project> search() {
		List<Project> filteredList = this.projects.stream().
				filter(p -> p.getName().toUpperCase().contains(searchText.toUpperCase())).toList();
		return filteredList;
	}

	public void setText(String newText) {
		this.searchText = newText;
		
	}
}
