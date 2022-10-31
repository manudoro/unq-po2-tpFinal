package ar.edu.unq.poo2.tpfinal.desafio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionTemporalTest {

	private RestriccionTemporal restriccionTemporal;
	private RestriccionTemporal restriccionTemporal2;
	private LocalTime tiempoHasta;
	private LocalTime tiempoDesde;
	private LocalDate fechaHasta;
	private LocalDate fechaDesde;
	private LocalDate fecha;
	
	@BeforeEach
	void setUp() {
		this.fecha  = LocalDate.of(2020, 6, 3);
		this.fechaDesde  = LocalDate.of(2020, 5, 3);
		this.fechaHasta  = LocalDate.of(2020, 5, 10);
		this.tiempoDesde = LocalTime.of(8, 30);
		this.tiempoHasta = LocalTime.of(20, 30);
		this.restriccionTemporal = new RestriccionTemporal(fechaDesde, fechaHasta, tiempoDesde, tiempoHasta);
		this.restriccionTemporal2 = new RestriccionTemporal(fecha, tiempoDesde, tiempoHasta);
	}
	
	@Test
	void seVerificaQueUnaRestriccionTemporalConoceSuFechaInicial() {
		LocalDateTime FechaYHorarioDeComienzoEsperado = LocalDateTime.of(this.fechaDesde, this.tiempoDesde);
		
		assertEquals(FechaYHorarioDeComienzoEsperado, this.restriccionTemporal.getTiempoTotalDesde());
	}
	
	@Test
	void seVerificaQueUnaRestriccionTemporalConoceSuFechaLimite() {
		LocalDateTime FechaYHorarioDeFinalEsperado = LocalDateTime.of(this.fechaHasta, this.tiempoHasta);
		
		assertEquals(FechaYHorarioDeFinalEsperado, this.restriccionTemporal.getTiempoTotalHasta());
	}
	
	@Test
	void cuandoUnaRestriccionTemporalRecibeUnaFecha_LaRestriccionSeFormaSoloPorElHorario() {
		LocalDateTime FechaYHorarioDeComienzoEsperado = LocalDateTime.of(this.fecha, this.tiempoDesde);
		LocalDateTime FechaYHorarioDeFinalEsperado = LocalDateTime.of(this.fecha, this.tiempoHasta);
		
		assertEquals(FechaYHorarioDeComienzoEsperado, this.restriccionTemporal2.getTiempoTotalDesde());
		assertEquals(FechaYHorarioDeFinalEsperado, this.restriccionTemporal2.getTiempoTotalHasta());
	}
	

}
