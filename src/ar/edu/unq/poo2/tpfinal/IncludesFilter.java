package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class IncludesFilter extends Filter {
	private List<String> categories;
	private List<Project> projects;	


	public IncludesFilter(List<String> categories, List<Project> projects) {
		this.categories = categories;
		this.projects = projects;
	}


	public List<Project> search() {
		List<Project> filteredProjects = projects.
				stream().filter(p -> p.getCategories().containsAll(categories)).toList();
		return filteredProjects;
	}


	public void addCategory(String category) {
		this.categories.add(category);
		
	}


	public List<String> getCategories() {
		return categories;
	}
}

