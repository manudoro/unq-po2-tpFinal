package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ConjunctionMethod implements ISearchMethod {

	@Override
	public List<Project> collect(List<List<Project>> allResults) {
		List<Project> result = new ArrayList<Project>();
		result.addAll(allResults.get(0));
		allResults.remove(0);
		for(List<Project> l : allResults) {
			result.retainAll(l);
		}
		return result;
	}
	
}
