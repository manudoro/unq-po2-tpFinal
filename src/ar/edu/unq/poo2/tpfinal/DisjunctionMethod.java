package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisjunctionMethod implements ISearchMethod{
	
	
	public List<Project> collect(List<List<Project>> allResult ){
		Set<Project> result = new HashSet<Project>();
		for(List<Project> ps : allResult ) {
			result.addAll(ps);
		}
	
		return new ArrayList<Project>(result);
	}
	
}
