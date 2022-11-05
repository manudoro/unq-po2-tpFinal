package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class ConjuncionDeFiltros extends FiltroCompuesto {
	Filtrable filtro2;

	
	public ConjuncionDeFiltros(Filtrable filtro1, Filtrable filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	protected List<Proyecto> recolectar(List<Proyecto> proyectos) {
		List<Proyecto> resultado = new ArrayList<Proyecto>(filtro1.buscar(proyectos));
		resultado.retainAll(filtro2.buscar(proyectos));
		return resultado;
	}
	
}
