package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class FiltroCompuesto implements Filtrable{
	Filtrable filtro1;
	Filtrable filtro2;
	
	public FiltroCompuesto(Filtrable filtro1, Filtrable filtro2) {

		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	@Override
	public final List<Proyecto> buscar() {	
		List<Proyecto> resultados1 = filtro1.buscar();
		List<Proyecto> resultados2 = filtro2.buscar();
		
		return this.recolectar(resultados1, resultados2);
	}
	


	protected abstract List<Proyecto> recolectar(List<Proyecto> resultados1, List<Proyecto> resultados2);
	
	public List<Proyecto> getProyectos(){
		
		Set<Proyecto> proyectos = new HashSet();
		proyectos.addAll(filtro1.getProyectos());
		proyectos.addAll(filtro2.getProyectos());
		
		return new ArrayList<Proyecto>(proyectos);
	}

	
	}
	
