package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Categoria;

public class FiltroDeExclucion extends Filtro {
	private List<Categoria> categorias;
	
	public FiltroDeExclucion(ArrayList<Categoria> categories) {
		this.categorias = categories;
	}
}
