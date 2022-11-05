package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroCompuesto implements Filtrable{
	Filtrable filtro1;


	@Override
	public final List<Proyecto> buscar(List<Proyecto> proyectos) {	

		
		return this.recolectar(proyectos);
	}
	


	protected abstract List<Proyecto> recolectar(List<Proyecto> proyectos);
	

	
	}
	
