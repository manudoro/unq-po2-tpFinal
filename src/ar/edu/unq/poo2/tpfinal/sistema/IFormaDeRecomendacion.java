package ar.edu.unq.poo2.tpfinal.sistema;

import java.util.ArrayList;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public interface IFormaDeRecomendacion {
	/* Una interfaz cuyo protocolo obliga, a quienes lo implementan, recomendar desafios */
	
	public ArrayList<Desafio>  recomendarDesafios(Usuario user , ArrayList<Desafio> challanges);
}
