package ar.edu.unq.poo2.tpfinal.filtro;


import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroTextoEnNombre extends FiltroSimple implements Filtrable {
	private String searchText;

	public FiltroTextoEnNombre(String text) {
		this.searchText = text;
	}

	
	@Override
	protected boolean validarProyecto(Proyecto p) {
		return p.contieneTextoEnNombre(searchText);
	}

}
