package ar.edu.unq.poo2.tpfinal;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.DiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.FinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.IRestriccionTemporal;

class TestRestriccionTemporal {

	private IRestriccionTemporal restriccionFinDeSemana, restriccionDiaDeSemana;
	private LocalDate fecha1, fecha2, fechaAValidarFinDeSemana, fechaAValidarDiaDeSemana ;
	@BeforeEach
	void setUp()  {

	restriccionFinDeSemana = new FinDeSemana();
	restriccionDiaDeSemana = new DiasDeSemana();
	

	fecha1 = LocalDate.of(2020, 7, 12);
	fecha2 = LocalDate.of(2021,8,18);
	fechaAValidarFinDeSemana = LocalDate.of(2022,11,5);
	fechaAValidarDiaDeSemana = LocalDate.of(2022,11,3);
	}

	@Test
	void testVerificarSiUnaFechaEsFinDeSemana() {
		assertTrue(restriccionFinDeSemana.validar(fechaAValidarFinDeSemana));
	}
	
	@Test
	
	void testVerificaSiUnaFechaNoEsFindeSeMana() {
		assertFalse(restriccionFinDeSemana.validar(fechaAValidarDiaDeSemana));
	}
	
	@Test
	void testVerificarSiUnaFechaEsDiaDeSemana() {
		assertTrue(restriccionDiaDeSemana.validar(fechaAValidarDiaDeSemana));
	}
	
	@Test
	
	void testVerificaSiUnaFechaNoEsDiaDeSemana() {
		assertFalse(restriccionDiaDeSemana.validar(fechaAValidarFinDeSemana));
	}
	

}
