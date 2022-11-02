package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class BusquedaDeConjuncion implements IMetodoDeBusqueda {

	@Override
	public List<Proyecto> recolectar(List<List<Proyecto>> allResults) {
		List<Proyecto> result = new ArrayList<Proyecto>();
		result.addAll(allResults.get(0));
		for(List<Proyecto> l : allResults) {
			result.retainAll(l);
		}
		return result;
	}
	
}
