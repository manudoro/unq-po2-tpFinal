package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class DisyuncionDeFiltros extends FiltroCompuesto{
	Filtrable filtro2;

	public DisyuncionDeFiltros(Filtrable filtro1, Filtrable filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	
	protected List<Proyecto> recolectar(List<Proyecto> proyectos){
		Set<Proyecto> result = new HashSet<Proyecto>();
		result.addAll(filtro1.buscar(proyectos));
		result.addAll(filtro2.buscar(proyectos));
		return new ArrayList<Proyecto>(result);
	}
	
}
