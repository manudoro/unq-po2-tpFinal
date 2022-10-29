package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ExcludesFilter extends Filter {
	private List<Category> categories;
	private List<Project> projects;

	public ExcludesFilter(List<Category> categories, List<Project> projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public List<Project> search() {
		List<Project> filteredProjects = projects.stream().
				filter(p -> this.excludesAll(p.getCategories())).toList();
		return filteredProjects;
		
	}

	private boolean excludesAll(List<Category> myCategories) {
		for(Category c : myCategories) {
			if (categories.contains(c)){
				return false;
			}
		}
		return true;
	}

	public void addCategory(Category category) {
		categories.add(category);
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void addProject(Project project) {
		this.projects.add(project);
		
	}
	
	
	
}
