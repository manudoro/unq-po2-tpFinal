package ar.edu.unq.poo2.tpfinal.desafio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class DesafioTest {

	private Desafio desafio, desafio2;
	private Coordenada punto , punto2;
	private Area area;
	private IRestriccionTemporal restriccionTemporal;
	private Usuario usuario1 , usuario2;
	private Muestra muestra , muestra2;
	
	
	@BeforeEach
	void setUp() {
		Dificultad facil = Dificultad.FACIL;
		LocalDate fecha = LocalDate.of(2020, 5, 19);
		this.punto = new Coordenada(3, 2);
		this.punto2 = new Coordenada(5,9);
		this.area = new Area(punto, 5);
		this.muestra = new Muestra(punto2, fecha);
		this.muestra2 = new Muestra(punto, fecha);
		
		this.usuario2 = mock(Usuario.class);
		this.usuario1 = new Usuario();
		this.desafio2 = mock(Desafio.class);
		this.desafio = new Desafio(area, 2, facil, 5, restriccionTemporal);
	}
	
	@Test
	void seVerificaQueUnDesafioConoceSuAreaDeRecoleccionPermitida() {
		assertEquals(this.area, this.desafio.getArea());
	}
	
	@Test
	void seVerificaQueUnDesafioConoceSuDificultad() {
		assertEquals(Dificultad.FACIL, this.desafio.getDificultad());
	}
	
	@Test
	void seVerificaQueUnDesafioConoceSuCantidadDeMuestrasARecolectarParaSerTerminado() {
		assertEquals(2, this.desafio.getCantidadDeMuestrasARecolectar());
	}
	
	@Test
	void seVerificaQueUnDesafioConoceSuCantidadDePuntos() {
		assertEquals(5, this.desafio.getRecompensa());
	}
	
	@Test
	void seVerificaQueUnDesafioConoceSuRestriccionTemporal() {
		assertEquals(this.restriccionTemporal, this.desafio.getRestriccionTemporal());
	}
	
	@Test
	void seVerificaQueUnDesafioGeneraUnDesafioParaUnUsuario() {
		this.desafio.asignarDesafioDeUsuario(usuario1);
		assertFalse(usuario1.getDesafiosDeUsuario().isEmpty());
		
	}


	@Test
	
	void seVerifcaSiUnaMuestra_NoEstaDentroDeLDesafio() {
		assertFalse(this.desafio.estaEnElArea(muestra));
	}
	
	
	@Test
	
	void seVerificaSiUnaMuestra_EstaDentroDelAreaDelDesafio() {
		assertTrue(this.desafio.estaEnElArea(muestra2));
	}
	
	
	
	
}
