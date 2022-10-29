package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisjunctionMethod {
	
	
	public List<Proyect> collect(List<List<Proyect>> allResult ){
		Set<Proyect> result = new HashSet<Proyect>();
		for(List<Proyect> ps : allResult ) {
			result.addAll(ps);
		}
	
		return new ArrayList<Proyect>(result);
	}
	
}
