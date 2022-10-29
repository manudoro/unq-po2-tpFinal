package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class CompositeFilter extends Filter{
	private ISearchMethod method;
	private List<Filter> filters;
	
	public CompositeFilter(ISearchMethod method ) {
		super();
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
	protected List<Project> search() {	
		List<List<Project>> allResult = new ArrayList<List<Project>>();
		for(Filter f : filters) {
			List<Project> result = f.search();
			allResult.add(result);
		}
		return method.collect(allResult);
	}
	
	

	
	
	
	
}
