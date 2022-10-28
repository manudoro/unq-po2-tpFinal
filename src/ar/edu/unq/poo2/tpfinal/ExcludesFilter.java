package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ExcludesFilter extends Filter {
	private List<Category> categories;
	private List<Proyect> proyects;

	public ExcludesFilter(List<Category> categories, List<Proyect> proyects) {
		this.categories = categories;
		this.proyects = proyects;
	}

	public List<Proyect> search() {
		List<Proyect> filteredProyects = proyects.stream().
				filter(p -> this.excludesAll(p.getCategories())).toList();
		return filteredProyects;
		
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

	public void addProyect(Proyect proyect) {
		this.proyects.add(proyect);
		
	}
	
	
	
}
