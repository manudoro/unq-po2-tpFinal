package ar.edu.unq.poo2.tpfinal.muestra;

public class Distancia {
	
	private int valorDistanciaAngular;
	
	public Distancia(int valorDistanciaAngular) {
		this.valorDistanciaAngular = valorDistanciaAngular;
	}
	
	public int getValor() {
		return valorDistanciaAngular;
	}

	public boolean esParteDelArea(Distancia tipoDeDistancia, int radio) {
		int valorDistancia = tipoDeDistancia.getValor();
		
		return Math.abs(valorDistancia - valorDistanciaAngular) <= radio;
	}
	
}
