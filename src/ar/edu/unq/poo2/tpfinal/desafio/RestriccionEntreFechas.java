package ar.edu.unq.poo2.tpfinal.desafio;

import java.time.LocalDate;

public class RestriccionEntreFechas implements IRestriccionTemporal{
	
	private LocalDate fechaInicio ;
	private LocalDate fechaFin;	
	
	
	
	public RestriccionEntreFechas(LocalDate fecha, LocalDate fecha2) {
		this.fechaInicio = fecha;
		this.fechaFin = fecha2;
	
	
	}


	@Override
	public boolean validar(LocalDate fecha) {
		

		return this.fechaInicio.isBefore(fecha.plusDays(1)) && this.fechaFin.isAfter(fecha.minusDays(1));
	}
	@Override
	public boolean estaAbierta(LocalDate fecha) {
		
		return validar(fecha);
	}


}