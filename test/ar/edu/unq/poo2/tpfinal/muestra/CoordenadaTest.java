package ar.edu.unq.poo2.tpfinal.muestra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordenadaTest {

	Coordenada coordenada , coordenada2;
	
	
	@BeforeEach
	void setUp() {
		coordenada = new Coordenada(9, 8);
		coordenada2 = new Coordenada(2,5);
	}

	@Test
	void testSeVerificaQueUnaDistanciaAngularNoEstaDentroDeUnCirculo() {
		int distanciaAngularDelCentroDelCirculo = 8;
		int distanciaAngularAVerificar = 2;
		int radioDelCirculo = 3;
		
		assertFalse(coordenada.esParteDelArea(distanciaAngularDelCentroDelCirculo, distanciaAngularAVerificar, radioDelCirculo));
	}
	
	@Test
	void testSeVerificaQueUnaDistanciaAngularEstaDentroDeUnCirculo() {
		int distanciaAngularDelCentroDelCirculo = 8;
		int distanciaAngularAVerificar = 2;
		int radioDelCirculo = 7;
		
		assertTrue(coordenada.esParteDelArea(distanciaAngularDelCentroDelCirculo, distanciaAngularAVerificar, radioDelCirculo));
	}
	
	@Test
	void testCuandoChequeamosSiUnaCoordenada_NoEstaDentroDeUnRadio() {
		
		assertFalse(coordenada.estaDentroConRespectoAlRadio(coordenada2, 5));
	}

	@Test
	void testCuandoChequeamosSiUnaCoordenada_EstaDentroDeUnRadio() {
		
		assertTrue(coordenada2.estaDentroConRespectoAlRadio(coordenada, 7 ));
	}
}
