package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public interface Filtrable {
	public List<Proyecto> buscar();

	public Set<Proyecto> getProyectos();
}
