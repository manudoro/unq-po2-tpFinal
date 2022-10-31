package ar.edu.unq.poo2.tpfinal.desafio;

import java.sql.Date;
import java.time.LocalDateTime;

public class Desafio {
	private Area area;
	private int cantidadDeMuestrasARecolectar;
	private Dificultad dificultad;
	private int recompensa;
	private RestriccionTemporal restriccionTemporal;
	
	public Desafio(Area area, int cantidadDeMuestrasARecolectar, Dificultad dificultad, int recompensa, RestriccionTemporal restriccionTemporal) {
		this.area = area;
		this.cantidadDeMuestrasARecolectar = cantidadDeMuestrasARecolectar;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.restriccionTemporal = restriccionTemporal;
	}

	public Area getArea() {
		return area;
	}

	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public RestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;
	}
	
	
	
	


}