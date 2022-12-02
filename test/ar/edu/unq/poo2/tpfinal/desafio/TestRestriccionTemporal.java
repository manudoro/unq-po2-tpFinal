package ar.edu.unq.poo2.tpfinal.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRestriccionTemporal {

	private IRestriccionTemporal restriccionFinDeSemana, restriccionDiaDeSemana , restriccionEntreSemana;
	private RestriccionMixta restriccionMixta ;
	private LocalDate fecha0, fecha1, fecha2, fecha3, fecha4, fechaAValidarFinDeSemana, fechaAValidarDiaDeSemana ;
	
	@BeforeEach
	void setUp()  {

	restriccionFinDeSemana = new RestriccionFinDeSemana();
	restriccionDiaDeSemana = new RestriccionDiasDeSemana();
	restriccionMixta = new RestriccionMixta();
	
	fecha0 = LocalDate.of(2000, 12, 12);
	fecha1 = LocalDate.of(2020, 7, 12);
	fecha2 = LocalDate.of(2021,8,18);
	fecha3 = LocalDate.of(2021,4,18);
	fecha4 = LocalDate.of(2021,2,18);
	fechaAValidarFinDeSemana = LocalDate.of(2022,11,5);
	fechaAValidarDiaDeSemana = LocalDate.of(2022,11,3);
	restriccionEntreSemana = new RestriccionEntreFechas(fecha1 ,fecha2);
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
	
	void testVerificarCuandoUnaRestriccionMixtaTieneRestriccionesQueCumplenConLaFechaYEsFinDeSemana() {
		restriccionMixta.agregarRestriccionTemporal(restriccionFinDeSemana);
		assertTrue(restriccionMixta.validar(fecha3));
	}
	
	@Test
	
	void testVerificarCuandoUnaRestriccionMixtaTieneRestriccionesQueCumplenConLaFechaYEsDiaDeSemana() {
		restriccionMixta.agregarRestriccionTemporal(restriccionDiaDeSemana);
		assertTrue(restriccionMixta.validar(fecha4));
	}
	
	@Test
	
	void testVerificarSiUnaFechaNoEstaEntreDosFechas() {
		assertFalse(restriccionEntreSemana.validar(fecha0));
	}
	
	@Test 
	
	void testVerificarSiUnaFechaEstaEntreDosFechas() {
		assertTrue(restriccionEntreSemana.validar(fecha4));
	}
	
	@Test
	
	void testVerificarCasoBordeInicioDeFechaEntreSemana() {
		assertTrue(restriccionEntreSemana.validar(fecha2));
	}
	@Test
	
	void testVerificarCasoBordeDeFinDeFechaEntreSemana() {
		assertTrue(restriccionEntreSemana.validar(fecha1));
	}
	
	@Test 
	void testVerificarCuandoUnaRestriccionMixtaTieneRestriccionesCombinadasConEntreSemanaYFinDeSemana() {
		restriccionMixta.agregarRestriccionTemporal(restriccionFinDeSemana);
		restriccionMixta.agregarRestriccionTemporal(restriccionEntreSemana);
		assertTrue(restriccionMixta.validar(fecha3));
	}
		
	@Test
	
	void testVerificarCuandoUnaRestriccionMixtaTieneRestriccionesCombinadasConEntreSemanaYDiaDeSemana() {
		restriccionMixta.agregarRestriccionTemporal(restriccionDiaDeSemana);
		restriccionMixta.agregarRestriccionTemporal(restriccionEntreSemana);
		assertTrue(restriccionMixta.validar(fecha4));
	}

	
}
