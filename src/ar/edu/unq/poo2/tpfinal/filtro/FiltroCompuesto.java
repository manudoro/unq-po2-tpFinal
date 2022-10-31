package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroCompuesto extends Filtro{
	private List<Filtro> filters;
	
	public FiltroCompuesto() {
		super();
		this.filters = new ArrayList<Filtro>();
	}

	
	public void agregarFiltro(Filtro filter) {
		this.filters.add(filter);
	}
	public void removerFiltro(Filtro filter) {
		this.filters.remove(filter);
	}
	abstract List<Proyecto> recolectar(List<List<Proyecto>> allResult);
	

	@Override
	protected final List<Proyecto> buscar() {	
		List<List<Proyecto>> allResult = new ArrayList<List<Proyecto>>();
		for(Filtro f : filters) {
			List<Proyecto> result = f.buscar();
			allResult.add(result);
		}
		List<Proyecto> resultados = this.recolectar(allResult);
		aplicarNegacion(filters, resultados);
		return resultados;
	}


	private void aplicarNegacion(List<Filtro> filters2, List<Proyecto> resultados) {
	
	}
	
}
