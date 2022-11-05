package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.HashSet;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroSimple implements Filtrable{
	List<Proyecto> projects;

	@Override
	public final List<Proyecto> buscar() {
		return this.recolectar();
	}


	protected abstract List<Proyecto> recolectar();


	@Override
	public List<Proyecto> getProyectos() {
		return this.projects;
	}
	
	public void agregarProyecto(Proyecto project) {
		this.projects.add(project);
		
	}

	
}
