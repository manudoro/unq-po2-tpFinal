package ar.edu.unq.poo2.tpfinal.muestra;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	private Muestra muestra1;
	private Coordenada cordenada1;
	private LocalDate fecha1;
	
	@BeforeEach
	void setUp() {
		cordenada1 = new Coordenada(5,2);
		fecha1 = LocalDate.of(2018, 10, 30);
		muestra1= new Muestra( cordenada1 , fecha1);
		
		
		
	}
	
	@Test
	void testUnaMuestraTieneUnaCoordenada(){
	
	assertEquals(muestra1.getCoordenada(),cordenada1);		
		
	}
	
	@Test
	
	void testUnaMuestraTieneUnaFechaDetermianda() {
		assertEquals(muestra1.getFechaDeRecoleccion(),fecha1);
	}
	

}
