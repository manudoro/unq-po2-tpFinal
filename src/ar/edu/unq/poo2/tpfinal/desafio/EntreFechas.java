package ar.edu.unq.poo2.tpfinal.desafio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntreFechas implements IRestriccionTemporal{
	
	private LocalDate fechaInicio ;
	private LocalDate fechaFin;	
	
	
	
	public EntreFechas(LocalDate fecha, LocalDate fecha2) {
		this.fechaInicio = fecha;
		this.fechaFin = fecha2;
	
	
	}



	@Override
	public boolean validar(LocalDate fecha) {
		// TODO Auto-generated method stub
		return false;
	}


}