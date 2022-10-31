package ar.edu.unq.poo2.tpfinal.desafio;

import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;

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

	
}
