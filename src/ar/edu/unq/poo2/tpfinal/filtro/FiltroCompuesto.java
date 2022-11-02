package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroCompuesto implements Filtrable{
	private IMetodoDeBusqueda method;
	private List<Filtrable> filters;
	
	public FiltroCompuesto(IMetodoDeBusqueda method ) {
		super();
		this.method = method;
		this.filters = new ArrayList<Filtrable>();
	}

	
	public void agregarFiltro(Filtrable filter) {
		this.filters.add(filter);
	}
	public void removerFiltro(Filtrable filter) {
		this.filters.remove(filter);
	}
	

	@Override
	public final List<Proyecto> buscar() {	
		List<List<Proyecto>> allResult = new ArrayList<List<Proyecto>>();
		for(Filtrable f : filters) {
			List<Proyecto> result = f.buscar();
			allResult.add(result);
		}
		return method.recolectar(allResult);
	}
	
}
