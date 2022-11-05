package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class NegacionDeFiltro implements Filtrable{
	Filtrable filtroANegar;
	
	public NegacionDeFiltro(Filtrable filtro) {
		this.filtroANegar = filtro;
	}
	
	public List<Proyecto> buscar() {

		List<Proyecto> proyectosDeFiltro = this.getProyectos();
		List<Proyecto> proyectosANegar = this.filtroANegar.buscar();
		proyectosDeFiltro.removeAll(proyectosANegar);		
		return proyectosDeFiltro;
		
	}
	
	public List<Proyecto> getProyectos() {
		return this.filtroANegar.getProyectos();
	}
	
}

