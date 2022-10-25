package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ExcludesFilter extends Filter {
	private List<Category> categories;
	
	public ExcludesFilter(ArrayList<Category> categories) {
		this.categories = categories;
	}
}
