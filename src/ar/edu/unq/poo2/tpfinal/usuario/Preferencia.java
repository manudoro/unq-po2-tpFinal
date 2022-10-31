package ar.edu.unq.poo2.tpfinal.usuario;

import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;

public class Preferencia {
	private Dificultad dificultad ;
	private int recompenzaPreferida ;
	private int cantidadDeMuestras;
	
	
	public Preferencia(Dificultad difficulty, int rewards, int amount) {
		this.dificultad = difficulty;
		this.recompenzaPreferida = rewards;
		this.cantidadDeMuestras = amount;
	}
	
	

}
