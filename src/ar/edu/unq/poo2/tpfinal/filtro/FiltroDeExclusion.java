package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class FiltroDeExclusion extends FiltroCategorias implements Filtrable {
	
	public FiltroDeExclusion(List<String> categories, List<Proyecto> projects) {
		this.categorias = categories;
		this.projects = projects;
	}

	@Override
	protected boolean validarProyecto(Proyecto p, List<String> categorias) {
		return p.excluyeCategorias(categorias);
	}
	
	




	
}
