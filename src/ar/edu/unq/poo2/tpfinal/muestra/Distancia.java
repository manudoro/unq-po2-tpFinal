package ar.edu.unq.poo2.tpfinal.muestra;

public class Distancia {
	
	private int valor;
	
	public Distancia(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	public boolean esParteDelArea(Distancia tipoDeDistancia, int radio) {
		int valorDistancia = tipoDeDistancia.getValor();
		
		return Math.abs(valorDistancia - valor) <= radio;
	}
	
}
