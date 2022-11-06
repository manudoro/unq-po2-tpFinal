package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.*;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.*;
import ar.edu.unq.poo2.tpfinal.muestra.*;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;


class DesafioDeUsuarioTest {

	private DesafioDeUsuario desafioDeUsuario, desafioDeUsuario2;
	private Desafio desafio , desafio2;
	private Muestra muestra, muestra1 , muestra2; 
	private FinDeSemana finDeSemana;
	private EntreFechas entreFecha;

	private Usuario usuario;

	private IEstadoDeDesafio estadoFinalizado,estadoAceptado,estadoSinAceptar;
	

	
	@BeforeEach
	void setUp() {
		
		/* Se crea la instancia de desafio para inicializarlo en la 
		   clase DesafioDeUsuario */
		
		
		Dificultad facil = Dificultad.FACIL;
		LocalDate fecha = LocalDate.of(2022, 11, 12);
		LocalDate fecha1 = LocalDate.of(2022, 11, 19);
		LocalDate fecha2 = LocalDate.of(2023, 10, 12);
		Coordenada punto = new Coordenada(5, 4);
		Coordenada punto2 = new Coordenada(15, 15);
		Coordenada punto3 = new Coordenada(3, 2);
		Area area = new Area(punto, 5);
		muestra = new Muestra(punto2,fecha);
		muestra1 = new Muestra(punto2,fecha2);
		muestra2 = new Muestra(punto3,fecha1);
		finDeSemana = new FinDeSemana();
		entreFecha = new EntreFechas(fecha, fecha1);
		desafio = new Desafio(area, 10, facil, 10, finDeSemana);
		desafio2 = new Desafio(area, 2, facil, 10, entreFecha);
		estadoFinalizado = new EstadoFinalizado();
		estadoAceptado = new EstadoAceptado();
		usuario = new Usuario();
	
		
		// <-- Instancia
		
		
		
		/* Se instancia un desafioDeUsuario
		 * Un desafio de usuario conoce el desafio que lo instancio para trabajar
		 * con sus atributos */
		
		this.desafioDeUsuario = new DesafioDeUsuario(desafio , usuario);
		 this.desafioDeUsuario2 = new DesafioDeUsuario(desafio2 ,usuario);
	}
	
	@Test
	void seVerificaQueUnDesafioDeUsuarioPuedeReducirSuCantidadDeMuestrasPorRecolectar() {
		/* Cuando se crea un desafioDeUsuario, comienza con 2 muestras por recolectar */
		this.desafioDeUsuario.getEstadoDeDesafio().reducirMuestrasPorRecolectar(); 
		
		assertEquals(9, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar());
	}
	
	@Test
	void cuandoElDesafioDeUsuarioEsteCompleto_NoSeVaAPoderModificarMasEsteDesafio() {
		/*Un desafio esta completo cuando su cantidad de muestras por recolectar llegue a cero
		 * La cantidad de muestras a recolectar actual es 2 */
		
		this.desafioDeUsuario2.getEstadoDeDesafio().reducirMuestrasPorRecolectar(); // <-- queda una muestra por recolectar
		this.desafioDeUsuario2.getEstadoDeDesafio().reducirMuestrasPorRecolectar(); // <-- ya no queda muestras por recolectar, su cantidad es cero (Cambio su estado a finalizado)
		this.desafioDeUsuario2.getEstadoDeDesafio().reducirMuestrasPorRecolectar(); // <-- la cantidad de muestras por recolectar debe seguir en cero
		
		
		assertEquals(0, this.desafioDeUsuario2.getCantidadDeMuestrasPorRecolectar());
	}
	
	@Test
	void seVerificaQueUnaMuestraNoSeEncuentraDentroDelAreaDeUnDesafioDeUsuario() {
		assertFalse(this.desafio.estaEnElArea(muestra1));
	}
	
	@Test
	void seVerificaQueUnaMuestraSeEncuentraDentroDelAreaDeUnDesafioDeUsuario() {
		assertTrue(this.desafio.estaEnElArea(muestra2));
	}
	
	@Test 
	void ceuandoUnDesafioDeUsuarioRecibeUnaMuestraYNostaDentroDeSuArea_NoSeRestaAlasMuestrasPorRecolectar() {
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		this.desafioDeUsuario.recibirMuestra(muestra);
	
		assertEquals(cantidadDeMuestras, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar() );
	}
	
	@Test 
	void cuandoUnDesafioDeUsuarioRecibeUnaMuestraYEstaDentroDeSuArea_SeRestaAlasMuestrasPorRecolectar() {
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		this.desafioDeUsuario.recibirMuestra(muestra2);
	
		assertEquals(9, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar() );
	}
	
	@Test
	
	void seVerificaSiUnaMuestra_EstaDentroDeLaFechaDeLaRestriccionTemporalDelDesafio() {
		assertTrue(this.desafio.correspondeARestriccion(muestra));
	}
	
	@Test
	
	void seVerificaSiUnaMuestra_NoEstaDentroDeLaFechaDeLaRestriccionTemporalDelDesafio() {
		assertFalse(this.desafio.correspondeARestriccion(muestra1));
	}
	
	
	@Test
	
	void chequeoPorcentajeDeComplejitudCuandoRecojoMuestra() {
		this.desafioDeUsuario.recibirMuestra(muestra2);
		assertEquals(10.0 ,this.desafioDeUsuario.getPorcentajeDeCompletitud());
	}
	
	@Test
	
	
	void verificarQueUnaMuestra_NoEsteDentroDeLaFechaDeLaRestriccionTemporalEntreSemana() {
		assertFalse(this.desafio2.correspondeARestriccion(muestra1));
	}
	
	@Test
	
	void verificarQueUnaMuestraEEsteDentroDeLaFechaDeLaRestriccionTemporalEntreSemana() {
		assertTrue(this.desafio2.correspondeARestriccion(muestra));
	}
	

	@Test
	
	void cuandoUnaMuestraNoEstaDentroDeLaFechaYElEstadoSeCambiaAFinalizado() {
		assertFalse(this.desafioDeUsuario2.restriccionEstaAbierta(muestra1));
		//assertEquals( estadoFinalizado.getClass() , this.desafioDeUsuario.getEstadoDeDesafio().getClass());
	}
	
}
