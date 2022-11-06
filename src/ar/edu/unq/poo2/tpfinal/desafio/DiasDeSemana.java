package ar.edu.unq.poo2.tpfinal.desafio;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DiasDeSemana implements IRestriccionTemporal {

	
	
	@Override
	public boolean validar(LocalDate fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;
	}

	@Override
	public boolean estaAbierta(LocalDate fecha) {
		//chequeamos si la restriccion puede volver a ser valida
		return true;
	}
}