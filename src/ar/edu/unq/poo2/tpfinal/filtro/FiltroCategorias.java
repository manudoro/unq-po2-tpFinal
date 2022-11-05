package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.HashSet;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroCategorias implements Filtrable{
	List<Proyecto> projects;
	List<String> categorias;

	@Override
	public final List<Proyecto> buscar() {
		return this.projects.stream().filter(p -> this.validarProyecto(p, categorias)).toList();
	}


	protected abstract boolean validarProyecto(Proyecto p, List<String> categorias);

	@Override
	public List<Proyecto> getProyectos() {
		return this.projects;
	}


	
}
