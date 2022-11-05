package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class NegacionDeFiltro extends FiltroSimple implements Filtrable{
	Filtrable filtroANegar;
	
	public NegacionDeFiltro(Filtrable filtro) {
		this.filtroANegar = filtro;
		this.proyectos = filtro.getProyectos();
	}

	@Override
	protected boolean validarProyecto(Proyecto p) {
		return !filtroANegar.buscar().contains(p);
	}
	
}

