package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public class Sistema {
	/* Se modela un sistema, su funcion es delegar la responsabilidad de los calculos de recomendacion
	   a una forma de recomendacion */

	List<Proyecto> proyectos;
	
	
	public Sistema() {
		this.proyectos = new ArrayList<Proyecto>();
	}
	
	
	public void agregarProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public void quitarProyecto(Proyecto proyecto) {
		proyectos.remove(proyecto);
	}
	
	
	
	
	
	
}
