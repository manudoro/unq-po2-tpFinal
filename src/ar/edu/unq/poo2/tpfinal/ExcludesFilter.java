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
				filter(p -> !p.getCategories().containsAll(categories)).toList();
		return filteredProyects;
		
	}

	public void addCategory(Category category) {
		categories.add(category);
		
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	
	
}
