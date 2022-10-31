package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ExcludesFilter extends Filter {
	private List<String> categories;
	private List<Project> projects;

	public ExcludesFilter(List<String> categories, List<Project> projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public List<Project> search() {
		List<Project> filteredProjects = projects.stream().
				filter(p -> this.excludesAll(p.getCategories())).toList();
		return filteredProjects;
		
	}

	private boolean excludesAll(List<String> myCategories) {
		for(String c : myCategories) {
			if (categories.contains(c)){
				return false;
			}
		}
		return true;
	}

	public void addCategory(String category) {
		categories.add(category);
		
	}

	public List<String> getCategories() {
		return categories;
	}

	public void addProject(Project project) {
		this.projects.add(project);
		
	}
	
	
	
}
