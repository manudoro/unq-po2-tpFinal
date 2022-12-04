package ar.edu.unq.poo2.tpfinal.muestra;

import java.time.LocalDate;

public class Muestra {
	
	/* Esta clase modela una muestra */

	private Coordenada coordenada;
	private LocalDate fechaDeRecoleccion;
	
	public Muestra(Coordenada cordinate, LocalDate date) {
		this.coordenada = cordinate;
		this.fechaDeRecoleccion = date;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public LocalDate getFechaDeRecoleccion() {
		return fechaDeRecoleccion;
	}
	
}
