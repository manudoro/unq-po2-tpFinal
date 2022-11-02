package ar.edu.unq.poo2.tpfinal.desafio;

import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class Area {
	
	private Coordenada centro;
	private Integer radio;
	public Area(Coordenada center, Integer radius) {
	
		this.centro = center;
		this.radio = radius;
	}
	public Coordenada getCentro() {
		return centro;
	}
	public void setCenter(Coordenada center) {
		this.centro = center;
	}
	public Integer getRadio() {
		return radio;
	}
	public void setRadius(Integer radius) {
		this.radio = radius;
	}
	
	public boolean estaDentro(Muestra muestra) {
		Coordenada coordenada = muestra.getCoordenada();
		
		return this.centro.estaDentroConRespectoAlRadio(coordenada, radio);
	}
}
