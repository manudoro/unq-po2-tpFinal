package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class NegacionDeFiltros extends FiltroCompuesto {
	protected List<Proyecto> recolectar(List<List<Proyecto>> allResults) {

		List<Proyecto> proyectosDeFiltros = new ArrayList(this.getProyectos());
		
		allResults.stream().forEach(l -> proyectosDeFiltros.removeAll(l));
		
		return proyectosDeFiltros;
		
	}
	
}

