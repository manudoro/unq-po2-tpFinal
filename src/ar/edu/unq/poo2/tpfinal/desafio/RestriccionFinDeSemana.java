package ar.edu.unq.poo2.tpfinal.desafio;


import java.time.DayOfWeek;
import java.time.LocalDate;


public class RestriccionFinDeSemana implements IRestriccionTemporal {
	
	@Override
	public boolean validar(LocalDate fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
	}


	
	
}
