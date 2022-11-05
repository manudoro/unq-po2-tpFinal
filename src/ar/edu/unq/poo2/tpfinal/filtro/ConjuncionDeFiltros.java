package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class ConjuncionDeFiltros extends FiltroCompuesto {

	
	public ConjuncionDeFiltros(Filtrable filtro1, Filtrable filtro2) {
		super(filtro1, filtro2);
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	protected List<Proyecto> recolectar(List<Proyecto> resultados1, List<Proyecto> resultados2) {
		List<Proyecto> resultado = new ArrayList<Proyecto>(resultados1);
		resultado.retainAll(resultados2);
		return resultado;
	}
	
}
