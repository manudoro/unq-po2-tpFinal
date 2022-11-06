package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;

class PreferenciaTest {

	private Preferencia preferencia;

	@BeforeEach
	void setUp() {
		this.preferencia = new Preferencia(Dificultad.MEDIO, 10, 11);
	}
	
	@Test
	void seVerificaQueUnaPreferenciaConoceSuDificultad() {
		assertEquals(Dificultad.MEDIO, preferencia.getDificultad());
	}
	
	@Test
	void seVerificaQueUnaPreferenciaConoceSuRecompenza() {
		assertEquals(10, preferencia.getRecompenzaPreferida());
	}
	
	@Test
	void seVerificaQueUnaPreferenciaConoceSuCantidadDeMuestras() {
		assertEquals(11, preferencia.getCantidadDeMuestras());
	}
	
	@Test
	void seVerificaQueSePuedeConfigurarUnaPreferencia() {
		preferencia.configurar(Dificultad.MUY_DIFICIL, 20, 30);
		
		assertEquals(Dificultad.MUY_DIFICIL, preferencia.getDificultad());
		assertEquals(20, preferencia.getRecompenzaPreferida());
		assertEquals(30, preferencia.getCantidadDeMuestras());
	}

	@Test
	void seVerificaQueUnaPreferenciaPuedeCalcularUnValorDeCoincidencia(){
		
		int absValorDeDificultad = Math.abs(this.preferencia.getDificultad().getValorDeDificultad() - 3);
		int absRecompensa = Math.abs(this.preferencia.getRecompenzaPreferida() - 15);
		int absCantidadDeMuestrasARecolectar =  Math.abs(this.preferencia.getCantidadDeMuestras() - 15);
		
		int resultado = absValorDeDificultad + absRecompensa + absCantidadDeMuestrasARecolectar;
		
		assertEquals(resultado, preferencia.calcularCoincidencia(3, 15, 15));
	}
}
