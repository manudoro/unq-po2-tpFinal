package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.*;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.*;
import ar.edu.unq.poo2.tpfinal.muestra.*;


class DesafioDeUsuarioTest {

	private DesafioDeUsuario desafioDeUsuario;
	private Desafio desafio;
	private Muestra muestra;
	private Muestra muestra2; 
	
	@BeforeEach
	void setUp() {
		
		/* Se crea la instancia de desafio para inicializarlo en la 
		   clase DesafioDeUsuario */
		
		
		Dificultad facil = Dificultad.FACIL;
		LocalDate fecha = LocalDate.of(2020, 5, 19);
		LocalTime tiempoDesde = LocalTime.of(7, 30);
		LocalTime tiempoHasta = LocalTime.of(19, 30);
		Coordenada punto = new Coordenada(5, 4);
		Coordenada punto2 = new Coordenada(15, 15);
		Area area = new Area(punto, 5);
		muestra = new Muestra(punto2,fecha);
		muestra2 = new Muestra(punto,fecha);
		RestriccionTemporal restriccionTemporal = new RestriccionTemporal(fecha, tiempoDesde, tiempoHasta);
		this.desafio = new Desafio(area, 2, facil, 5, restriccionTemporal); // <-- Instancia
		
		
		
		/* Se instancia un desafioDeUsuario
		 * Un desafio de usuario conoce el desafio que lo instancio para trabajar
		 * con sus atributos */
		
		this.desafioDeUsuario = new DesafioDeUsuario(desafio);
	}
	
	@Test
	void seVerificaQueUnDesafioDeUsuarioPuedeReducirSuCantidadDeMuestrasPorRecolectar() {
		/* Cuando se crea un desafioDeUsuario, comienza con 2 muestras por recolectar */
		this.desafioDeUsuario.reducirMuestrasPorRecolectar(); 
		
		assertEquals(1, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar());
	}
	
	@Test
	void cuandoElDesafioDeUsuarioEsteCompleto_NoSeVaAPoderModificarMasEsteDesafio() {
		/*Un desafio esta completo cuando su cantidad de muestras por recolectar llegue a cero
		 * La cantidad de muestras a recolectar actual es 2 */
		
		this.desafioDeUsuario.reducirMuestrasPorRecolectar(); // <-- queda una muestra por recolectar
		this.desafioDeUsuario.reducirMuestrasPorRecolectar(); // <-- ya no queda muestras por recolectar, su cantidad es cero (Cambio su estado a finalizado)
		this.desafioDeUsuario.reducirMuestrasPorRecolectar(); // <-- la cantidad de muestras por recolectar debe seguir en cero
		
		assertEquals(0, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar());
	}
	
	@Test 
	void cuandoUnDesafioDeUsuarioRecibeUnaMuestraYNoestaDentroDeSuArea_NoSeRestaAlasMuestrasPorRecolectar() {
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		this.desafioDeUsuario.recibirMuestra(muestra);
	
		assertEquals(cantidadDeMuestras, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar() );
	}
	
	@Test 
	void cuandoUnDesafioDeUsuarioRecibeUnaMuestraYEstaDentroDeSuArea_SeRestaAlasMuestrasPorRecolectar() {
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		this.desafioDeUsuario.recibirMuestra(muestra2);
	
		assertEquals(1, this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar() );
	}

}
