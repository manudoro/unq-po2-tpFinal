package ar.edu.unq.poo2.tpfinal.desafio;

import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class Area {
	
	private Coordenada center;
	private Integer radius;
	public Area(Coordenada center, Integer radius) {
	
		this.center = center;
		this.radius = radius;
	}
	public Coordenada getCenter() {
		return center;
	}
	public void setCenter(Coordenada center) {
		this.center = center;
	}
	public Integer getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	
	// diferenciaDeLongitudConMuestra y diferenciaDeLatitudConMuestra se pueden RECONTRA MEJORAR.
	
	public int diferenciaDeLongitudConMuestra(Muestra muestra) {
		//este metodo permite obtener la diferencia entre la altura del area y la ubicacion 
		// de la muestra en el eje Y
		return this.getCenter().getY() - muestra.getCoordenada().getY();
	}
	
	public int diferenciaDeLatitudConMuestra(Muestra muestra) {
		//este metodo permite obtener la diferencia entre el ancho del area y la ubicacion 
		// de la muestra en el eje X
		return this.getCenter().getX() - muestra.getCoordenada().getX();
	}
	
	public boolean estanLasDistanciasDentroDelRadio(int resultadoLatitud, int resultadoLongitud) {
		return distanciaEstaComprendida(resultadoLongitud) && distanciaEstaComprendida(resultadoLatitud);
	}
	
	private boolean distanciaEstaComprendida(int resultadoDistancia) {
		return resultadoDistancia <= this.getRadius();
	}
}
