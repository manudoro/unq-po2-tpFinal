package ar.edu.unq.poo2.tpfinal.desafio;

import java.sql.Date;

public class Desafio {
	private Area area;
	private Integer cantidadDeMuestrasARecolectar;
	private String dificultad;
	private String recompensa;
	private Date restriccionTemporal;
	
	public Desafio(Area area, Integer challangeTarget, String difficulty, String rewards, Date date) {
		this.area = area;
		this.cantidadDeMuestrasARecolectar = challangeTarget;
		this.dificultad = difficulty;
		this.recompensa = rewards;
		this.restriccionTemporal = date;
	}

	
	


}
