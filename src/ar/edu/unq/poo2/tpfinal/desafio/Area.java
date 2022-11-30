package ar.edu.unq.poo2.tpfinal.desafio;

import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class Area {
	
	private Coordenada centro;
	private int radio;
	
	public Area(Coordenada centro, int radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Coordenada getCentro() {
		return centro;
	}
	
	public void setCenter(Coordenada centro) {
		this.centro = centro;
	}
	
	public int getRadio() {
		return radio;
	}
	
	public void setRadius(int radio) {
		this.radio = radio;
	}
	
	public boolean estaDentro(Muestra muestra) {
		Coordenada coordenada = muestra.getCoordenada();
		
		return this.centro.estaDentroConRespectoAlRadio(coordenada, radio);
	}
}
