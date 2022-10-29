package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class IncludesFilter extends Filter {
	private List<Category> categories;
	private List<Project> projects;	


	public IncludesFilter(List<Category> categories, List<Project> projects) {
		this.categories = categories;
		this.projects = projects;
	}


	public List<Project> search() {
		List<Project> filteredProjects = projects.
				stream().filter(p -> p.getCategories().containsAll(categories)).toList();
		return filteredProjects;
	}


	public void addCategory(Category category) {
		this.categories.add(category);
		
	}


	public List<Category> getCategories() {
		return categories;
	}
}

