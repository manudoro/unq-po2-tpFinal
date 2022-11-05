package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class NegacionDeFiltro extends FiltroCompuesto implements Filtrable{
	Filtrable filtroANegar;
	
	public NegacionDeFiltro(Filtrable filtro) {
		this.filtroANegar = filtro;
	}

	@Override
	protected List<Proyecto> recolectar(List<Proyecto> proyectos) {
		List<Proyecto> resultado = filtroANegar.buscar(proyectos);
		proyectos.removeAll(resultado);
		return proyectos;
	}
	
}

