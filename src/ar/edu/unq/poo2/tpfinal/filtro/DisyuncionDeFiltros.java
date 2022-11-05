package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class DisyuncionDeFiltros extends FiltroCompuesto{
	
	public DisyuncionDeFiltros(Filtrable filtro1, Filtrable filtro2) {
		super(filtro1, filtro2);
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	
	protected List<Proyecto> recolectar(List<Proyecto> resultados1, List<Proyecto> resultados2){
		Set<Proyecto> result = new HashSet<Proyecto>();
		result.addAll(resultados1);
		result.addAll(resultados2);
		return new ArrayList<Proyecto>(result);
	}
	
}
