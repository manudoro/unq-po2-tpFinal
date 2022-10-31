package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Sistema {
	
	/* Se modela un sistema, su funcion es delegar la responsabilidad de los calculos de recomendacion
	   a una forma de recomendacion */
	
	private IFormaDeRecomendacion recomendation;
	private Usuario user;
	private List<Desafio> challangesRecommeded;
	
	
	public Sistema(IFormaDeRecomendacion recomendation, Usuario user) {
	
		this.recomendation = recomendation;
		this.user = user;
		this.challangesRecommeded = new ArrayList<Desafio>();
	}
	
	
	
	
	
	
}
