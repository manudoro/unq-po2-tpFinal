package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Sistema {
	/* Se modela un sistema, su funcion es delegar la responsabilidad de los calculos de recomendacion
	   a una forma de recomendacion */
	IFormaDeRecomendacion formaDeRecomendacion;
	public Sistema(){
		// se setea la recomendacion por preferencias de usuario por default
		this.formaDeRecomendacion = new PreferenciasDeUsuario();
		
	}
	// se buscan los desafios de los proyectos con participacion del usuario y se restan 
	// los ya comenzados por el mismo
	public List<Desafio> desafiosRecomendables(Usuario usuario) {
		List <Desafio> desafiosARecomendar = new ArrayList<Desafio>();
		usuario.getProyectos().forEach(p-> desafiosARecomendar.addAll(p.getDesafios()));
		desafiosARecomendar.removeAll(usuario.desafiosComenzados());
		
		return desafiosARecomendar;
	}
	
	public void setStrategy(IFormaDeRecomendacion recomendacion) {
		this.formaDeRecomendacion = recomendacion;
	}
	
	public List<Desafio> recomendarDesafios(Usuario usuario){
		return this.formaDeRecomendacion.recomendarDesafios(usuario, desafiosRecomendables(usuario));
	}
	
	
	
	
	
	
}
