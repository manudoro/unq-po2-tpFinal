package ar.edu.unq.poo2.tpfinal.muestra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.muestra.Distancia;

class DistanciaTest {

	private Distancia distancia, distancia2;
	
	@BeforeEach
	void setUp() throws Exception {
	
	distancia = new Distancia(2);
	distancia2 = new Distancia(10);
	
	}

	@Test
	void testCuandoChequamosQueUnaDistancia_NoEsteDentroDeUnArea() {
		assertFalse(distancia.esParteDelArea(distancia2, 3));
		
	}
	
	@Test
	
	void testCuandoChequeamosQueUnaDistancia_EstaDentroDelArea() {
		assertTrue(distancia.esParteDelArea(distancia2, 10));
	}

}
