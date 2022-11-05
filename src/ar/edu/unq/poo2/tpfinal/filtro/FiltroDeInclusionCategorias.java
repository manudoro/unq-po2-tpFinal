package ar.edu.unq.poo2.tpfinal.filtro;


import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeInclusionCategorias extends FiltroSimple  implements Filtrable {
	List<String> categorias;
	
	
	public FiltroDeInclusionCategorias(List<String> categories) {
		this.categorias = categories;
	}


	@Override
	protected boolean validarProyecto(Proyecto p) {
		return p.contieneCategorias(this.categorias);
	}
	
}

