package ar.edu.unq.poo2.tpfinal.usuario;

import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;

public class Preferencia {
	private Dificultad dificultad ;
	private int recompenzaPreferida ;
	private int cantidadDeMuestras;
	
	
	public Preferencia(Dificultad dificultad, int recompenza, int cantidadDeMuestras) {
		this.dificultad = dificultad;
		this.recompenzaPreferida = recompenza;
		this.cantidadDeMuestras = cantidadDeMuestras;
	}


	
	public Dificultad getDificultad() {
		return dificultad;
	}



	public int getRecompenzaPreferida() {
		return recompenzaPreferida;
	}



	public int getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}



	public void configurar(Dificultad dificultad, int recompenza, int cantidadDeMuestras) {
		this.dificultad = dificultad;
		this.recompenzaPreferida = recompenza;
		this.cantidadDeMuestras = cantidadDeMuestras;
	}



	public int calcularCoincidencia(int valorDeDificultad, int recompensa, int cantidadDeMuestrasARecolectar) {
		
		int absValorDeDificultad = Math.abs(this.getDificultad().getValorDeDificultad() - valorDeDificultad);
		int absRecompensa = Math.abs(this.getRecompenzaPreferida() - recompensa);
		int absCantidadDeMuestrasARecolectar = Math.abs(this.getCantidadDeMuestras() - cantidadDeMuestrasARecolectar);
		
		int resultado = absValorDeDificultad + absRecompensa + absCantidadDeMuestrasARecolectar;
		
		return resultado;
	}
	
	

}
