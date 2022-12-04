package ar.edu.unq.poo2.tpfinal.recomendacion;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class FormaDeRecomendacionFavorito implements IFormaDeRecomendacion {
	
	// Para que esta recomendacion funcione, el usuario debe participar en al menos un proyecto y un desafio de ese proyecto

	@Override
	public List<Desafio> ordenar(List<Desafio> desafiosARecomendar, Usuario usuario) {
		
		List<Desafio> desafiosPorCoincidencia = desafiosARecomendar.stream()
			    												.sorted((d1, d2) -> d1.valorDeCoincidenciaConPreferencia(usuario.getPreferencia())
			    																	  .compareTo(d2.valorDeCoincidenciaConPreferencia(usuario.getPreferencia())))
			    												.limit(20)
			    												.toList();
		Desafio desafio = usuario.mejorDesafio();
		
		List<Desafio> desafiosPorFavorito = desafiosPorCoincidencia.stream()
															       .sorted((d1, d2) -> d1.calcularDistanciaConDesafio(desafio)
																				         .compareTo(d2.calcularDistanciaConDesafio(desafio)))
															       .limit(5)
															       .toList();
		return desafiosPorFavorito;
	}
}
