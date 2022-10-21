package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class IncludesFilter extends Filter {
	private List<Category> categories;
	
	public IncludesFilter(ArrayList<Category> categories) {
		this.categories = categories;
	}
}

