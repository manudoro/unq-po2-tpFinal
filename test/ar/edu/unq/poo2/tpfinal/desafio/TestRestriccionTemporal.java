package ar.edu.unq.poo2.tpfinal.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.DiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.EntreFechas;
import ar.edu.unq.poo2.tpfinal.desafio.FinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.IRestriccionTemporal;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionMixta;

class TestRestriccionTemporal {

	private IRestriccionTemporal restriccionFinDeSemana, restriccionDiaDeSemana , restriccionEntreSemana;
	private RestriccionMixta restriccionMixta ;
	private LocalDate fecha1, fecha2, fecha3, fecha4, fechaAValidarFinDeSemana, fechaAValidarDiaDeSemana ;
	
	@BeforeEach
	void setUp()  {

	restriccionFinDeSemana = new FinDeSemana();
	restriccionDiaDeSemana = new DiasDeSemana();
	restriccionMixta = new RestriccionMixta();

	fecha1 = LocalDate.of(2020, 7, 12);
	fecha2 = LocalDate.of(2021,8,18);
	fecha3 = LocalDate.of(2022,11,27);
	fecha4 = LocalDate.of(2021,2,18);
	fechaAValidarFinDeSemana = LocalDate.of(2022,11,5);
	fechaAValidarDiaDeSemana = LocalDate.of(2022,11,3);
	restriccionEntreSemana = new EntreFechas(fecha1 ,fecha2);
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
	
	@Test
	
	void testVerificarCuandoUnaRestriccionMixtaAgregaUnaRestriccion() {
		restriccionMixta.agregarRestriccionTemporal(restriccionDiaDeSemana);
		assertEquals(restriccionMixta.getRestricciones().size() , 1);
	}
	
	@Test
	
	void testVerificarCuandoUnaRestriccionMixtaNoTieneRestricciones() {
		assertTrue(restriccionMixta.getRestricciones().isEmpty());
	}
	
	@Test 
	
	void testVerificarCuandoUnaRestriccionMixtaRemueveUnaRestriccion() {
		restriccionMixta.agregarRestriccionTemporal(restriccionFinDeSemana);
		restriccionMixta.removerRestriccionTemporal(restriccionFinDeSemana);
		assertTrue(restriccionMixta.getRestricciones().isEmpty());
	}
	
	@Test 
	
	void testVerificarCuandoUnaRestriccionMixtaTieneRestriccionesQueCumplenConLaFecha() {
		restriccionMixta.agregarRestriccionTemporal(restriccionFinDeSemana);
		restriccionMixta.agregarRestriccionTemporal(restriccionFinDeSemana);
		assertTrue(restriccionMixta.validar(fecha3));
	}
	
	
	@Test
	
	void testVerificarSiUnaFechaNoEstaEntreDosFechas() {
		assertFalse(restriccionEntreSemana.validar(fecha3));
	}
	
	@Test 
	
	void testVerificarSiUnaFechaEstaEntreDosFechas() {
		assertTrue(restriccionEntreSemana.validar(fecha4));
	}
	
	
	
}
