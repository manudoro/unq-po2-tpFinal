package ar.edu.unq.poo2.tpfinal.muestra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordenadaTest {

	Coordenada coordenada , coordenada2;
	Distancia distanciaLongitud , distanciaLatitud;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		distanciaLongitud = new Distancia(9);
		distanciaLatitud = new Distancia(8);
		coordenada = new Coordenada(distanciaLongitud.getValor() , distanciaLatitud.getValor());
		coordenada2 = new Coordenada(2,5);
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
