package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroTextoEnNombre extends FiltroSimple implements Filtrable {
	private String searchText;

	public FiltroTextoEnNombre(String text, List<Proyecto> projects) {
		this.searchText = text;
		this.proyectos = projects;
	}


	@Override
	protected boolean validarProyecto(Proyecto p) {
		return p.contieneTextoEnNombre(searchText);
	}

}
