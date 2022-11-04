package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Sistema {
	/* Se modela un sistema, su funcion es delegar la responsabilidad de los calculos de recomendacion
	   a una forma de recomendacion */

	public ArrayList<Desafio> recomendarDesafios(Usuario usuario) {
		ArrayList<Desafio> desafiosRecomendados = new ArrayList<Desafio>();
		
		if (usuario.participaEnProyectos()) {
			return desafiosRecomendados;
		}
		
		return null;
	}
	

	
	
	
	
	
	
	
}
