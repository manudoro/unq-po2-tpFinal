package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroCompuesto implements Filtrable{
	List<Filtrable> filters;
	
	public FiltroCompuesto() {

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
		return this.recolectar(allResult);
	}
	


	protected abstract List<Proyecto> recolectar(List<List<Proyecto>> allResult);
	
	public List<Proyecto> getProyectos(){
		
		Set<Proyecto> setProyectos = filters.stream().flatMap(f-> f.getProyectos().stream()).collect(Collectors.toSet());
		
		return new ArrayList<Proyecto>(setProyectos);
	}

	
	}
	
