package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Preferencia;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class FormaDeRecomendacionPreferencia implements IFormaDeRecomendacion {

	@Override
	public List<Desafio> ordenar(List<Desafio> desafiosARecomendar, Usuario usuario) {
		List<Desafio> desafiosRecomendados = desafiosARecomendar.stream()
															    .sorted((d1, d2) -> d1.valorDeCoincidenciaConPreferencia(usuario.getPreferencia())
															    .compareTo(d2.valorDeCoincidenciaConPreferencia(usuario.getPreferencia())))
															    .limit(5)
															    .toList();
		return desafiosRecomendados;
	}


}
