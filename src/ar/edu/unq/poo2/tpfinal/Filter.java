package ar.edu.unq.poo2.tpfinal;

import java.util.List;

public abstract class Filter {
	
	private List<Proyect> proyects;

	public Filter() {
		this.proyects = proyects;
	}
	
	protected abstract List<Proyect> 
	search();
	
	
	
	
}
