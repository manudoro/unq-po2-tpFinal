package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

public abstract class Filtro {
	private List<Proyecto> proyectos;
	
	abstract List<Proyecto> buscar(); 
}
