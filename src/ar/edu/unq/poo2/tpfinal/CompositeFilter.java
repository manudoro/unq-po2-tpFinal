package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class CompositeFilter extends Filter{
	private List<Proyect> proyects;
	private ISearchMethod method;
	private List<Filter> filters;
	
	public CompositeFilter(List<Proyect> proyects , ISearchMethod method ) {
		super();
		this.proyects = proyects;
		this.method = method;
		this.filters = new ArrayList<Filter>();
	}

	
	public void addFilter(Filter filter) {
		this.filters.add(filter);
	}
	public void removeFilter(Filter filter) {
		this.filters.remove(filter);
	}
	

	@Override
	protected List<Proyect> search() {	
		List<List<Proyect>> allResult = new ArrayList<List<Proyect>>();
		for(Filter f : filters) {
			List<Proyect> result = f.search();
			allResult.add(result);
		}
		return method.collect(allResult);
	}
	
	

	
	
	
	
}
