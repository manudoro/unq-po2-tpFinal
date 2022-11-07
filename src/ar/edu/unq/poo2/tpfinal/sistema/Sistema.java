package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.*;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Sistema {
	/* Se modela un sistema, su funcion es delegar la responsabilidad de los calculos de recomendacion
	   a una forma de recomendacion */

	public List<Desafio> recomendarDesafios(Usuario usuario, IFormaDeRecomendacion formaDeRecomendacion) {
		
		ArrayList<Desafio> desafiosARecomendar = usuario.desafiosSinHacer();
		
		List<Desafio> desafiosOrdenados = formaDeRecomendacion.ordenar(desafiosARecomendar,  usuario);
				
		return desafiosOrdenados;
			
	}

	
	
	
	
	
	
	
}
