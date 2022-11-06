package ar.edu.unq.poo2.tpfinal.desafio;

import java.time.LocalDate;

public interface IRestriccionTemporal {
	
	boolean validar(LocalDate fecha);
	boolean estaAbierta(LocalDate fecha);
}
