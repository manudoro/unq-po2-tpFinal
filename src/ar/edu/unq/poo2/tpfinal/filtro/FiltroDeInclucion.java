package ar.edu.unq.poo2.tpfinal.filtro;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.proyecto.Categoria;

public class FiltroDeInclucion extends Filtro {
	private List<Categoria> categorias;
	
	public FiltroDeInclucion(ArrayList<Categoria> categories) {
		this.categorias = categories;
	}
}

