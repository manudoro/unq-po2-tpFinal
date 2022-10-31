package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltoDeDisyuncion extends FiltroCompuesto{
	

	public List<Proyecto> recolectar(List<List<Proyecto>> allResult ){
		Set<Proyecto> result = new HashSet<Proyecto>();
		for(List<Proyecto> ps : allResult ) {
			result.addAll(ps);
		}
	
		return new ArrayList<Proyecto>(result);
	}
	
}
