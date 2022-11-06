package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class PreferenciasDeUsuario implements IFormaDeRecomendacion {

	public List<Desafio> recomendarDesafios(Usuario user, List<Desafio> desafios) {
		List<Desafio> mayorCoincidencia = desafios.stream().
				sorted((d1, d2) -> d1.getCoincidencia(user.getPreferencia()).
						compareTo(d2.getCoincidencia(user.getPreferencia()))).limit(5).toList();
		return mayorCoincidencia;
	}

}
