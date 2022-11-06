package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public interface IFormaDeRecomendacion {
	/* Una interfaz cuyo protocolo obliga, a quienes lo implementan, recomendar desafios */
	
	public List<Desafio>  recomendarDesafios(Usuario user , List<Desafio> challanges);
}
