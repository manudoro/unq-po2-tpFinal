package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class BusquedaDeDisyuncion extends FiltroCompuesto{
	
	
	protected List<Proyecto> recolectar(List<List<Proyecto>> allResult ){
		Set<Proyecto> result = new HashSet<Proyecto>();
		for(List<Proyecto> ps : allResult ) {
			result.addAll(ps);
		}
	
		return new ArrayList<Proyecto>(result);
	}
	
	public Filtrable negar() {
		BusquedaDeConjuncion filtroConjunto = new BusquedaDeConjuncion();
		this.traspasarFiltrosNegados(filtroConjunto);
		return filtroConjunto;
	}
}
