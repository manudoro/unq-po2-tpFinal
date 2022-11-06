package ar.edu.unq.poo2.tpfinal.usuario;

import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;

public class Preferencia {
	private Dificultad dificultad ;
	private int recompensaPreferida ;
	private int cantidadDeMuestras;
	
	
	public Preferencia(Dificultad difficulty, int rewards, int amount) {
		this.dificultad = difficulty;
		this.recompensaPreferida = rewards;
		this.cantidadDeMuestras = amount;
	}


	public int getDificultad() {
		// TODO Auto-generated method stub
		return dificultad.getValorDeDificultad();
	}
	
	public int getRecompensaPreferida() {
		// TODO Auto-generated method stub
		return this.recompensaPreferida;
	}


	public int getCantidadMuestras() {
		// TODO Auto-generated method stub
		return this.cantidadDeMuestras;
	}

}
