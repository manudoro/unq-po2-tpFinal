package ar.edu.unq.poo2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RestriccionTemporal {

	private LocalDateTime tiempoTotalDesde;
	private LocalDateTime tiempoTotalHasta;

	public RestriccionTemporal(LocalDate fechaDesde, LocalDate fechaHasta, LocalTime tiempoDesde,
			LocalTime tiempoHasta) {
		/* Este constructor cubre el caso en el que recibe dos fechas y dos horarios */

		this.tiempoTotalDesde = LocalDateTime.of(fechaDesde, tiempoDesde);
		this.tiempoTotalHasta = LocalDateTime.of(fechaHasta, tiempoHasta);
	}

	public RestriccionTemporal(LocalDate fecha, LocalTime tiempoDesde, LocalTime tiempoHasta) {
		/* Este constructor cubre el caso en el que recibe una fecha y dos horarios */
		
		this.tiempoTotalDesde = LocalDateTime.of(fecha, tiempoDesde);
		this.tiempoTotalHasta = LocalDateTime.of(fecha, tiempoHasta);
	}

	public LocalDateTime getTiempoTotalDesde() {
		return tiempoTotalDesde;
	}

	public LocalDateTime getTiempoTotalHasta() {
		return tiempoTotalHasta;
	}
	

}
