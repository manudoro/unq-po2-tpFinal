package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Preferencia;

public class FormaDeRecomendacionPreferencia implements IFormaDeRecomendacion {

	@Override
	public List<Desafio> ordenar(List<Desafio> desafiosARecomendar, Preferencia preferencia) {
		List<Desafio> desafiosRecomendados = desafiosARecomendar.stream()
															    .sorted((d1, d2) -> d1.valorDeCoincidenciaConPreferencia(preferencia)
															    .compareTo(d2.valorDeCoincidenciaConPreferencia(preferencia)))
															    .limit(5)
															    .toList();
		return desafiosRecomendados;
	}


}
