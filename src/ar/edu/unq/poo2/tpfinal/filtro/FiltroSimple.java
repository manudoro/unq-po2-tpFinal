package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroSimple implements Filtrable{
	

	@Override
	public final List<Proyecto> buscar(List<Proyecto> proyectos){
		return proyectos.stream().filter(p -> this.validarProyecto(p)).toList();
	}


	protected abstract boolean validarProyecto(Proyecto p);


	
}
