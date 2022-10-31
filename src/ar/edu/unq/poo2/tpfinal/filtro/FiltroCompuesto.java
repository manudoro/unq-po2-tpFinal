package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroCompuesto extends Filtro{
	private IMetodoDeBusqueda method;
	private List<Filtro> filters;
	
	public FiltroCompuesto(IMetodoDeBusqueda method ) {
		super();
		this.method = method;
		this.filters = new ArrayList<Filtro>();
	}

	
	public void agregarFiltro(Filtro filter) {
		this.filters.add(filter);
	}
	public void removerFiltro(Filtro filter) {
		this.filters.remove(filter);
	}
	

	@Override
	protected List<Proyecto> buscar() {	
		List<List<Proyecto>> allResult = new ArrayList<List<Proyecto>>();
		for(Filtro f : filters) {
			List<Proyecto> result = f.buscar();
			allResult.add(result);
		}
		return method.recolectar(allResult);
	}
	
}
