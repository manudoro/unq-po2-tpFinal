package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.FinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {

	private Proyecto proyecto;
	private Usuario usuario1 , usuario2;
	private Muestra muestra;
	private Desafio desafio2;
	private String categoria;
	private Desafio desafio1;

	
	@BeforeEach
	void setUp(){
		// Se crean instancias de Desafio.
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		FinDeSemana finDeSemana = new FinDeSemana();
		Dificultad facil = Dificultad.FACIL;
		
		desafio1 = new Desafio(area, 1, facil, 1, finDeSemana);
		desafio2 = new Desafio(area, 2, facil, 2, finDeSemana);
		
		proyecto = new Proyecto("AquatiWord", "Cs.Natural");
		usuario1 = mock(Usuario.class);
		categoria = "Botanica";
		
	}

	@Test
	void testSeVerificaQueSePuedeSuscribirUnUsuarioAUnProyecto()	 {
		proyecto.suscribirUsuario(usuario1);
		assertEquals(proyecto.getUsuarios().size() , 1);	
	}

	@Test 
	void testSeVerificaQueUnProyectoPuedeDesuscribirUsuarios(){
		proyecto.suscribirUsuario(usuario1);
		proyecto.desuscribirUsuario(usuario1);
		assertEquals(proyecto.getUsuarios().size(), 0);
	}
	
	@Test
	
	void testSeVerificaQueSePuedeVincularUnaCategoriaAUnProyecto() {
		proyecto.vincularACategoria(categoria);
		assertEquals(proyecto.getCategorias().size() , 1);	
		
	}
	
	@Test
	void cuandoUnProyectoQueNoPoseeDesafiosRecibeDesafiosDeUsuario_NoDevuelveNada() {
		Desafio desafio = mock(Desafio.class);
		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(new DesafioDeUsuario(desafio , usuario1));
		
		List<Desafio> desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		
		assertTrue(desafiosSinHacer.isEmpty());
	}
	
	@Test
	void cuandoUnProyectoQuePoseeDesafiosRecibeDesafiosDeUsuario_YElDesafioEstaEnLosDelUsuario_NoDevuelveNada() {
		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		
		desafiosDeUsuario.add(new DesafioDeUsuario(desafio1 , usuario1));
		proyecto.recibirDesafio(desafio1);
		
		List<Desafio> desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		
		assertTrue(desafiosSinHacer.isEmpty());
	}
	
	@Test
	void cuandoUnProyectoQuePoseeDesafiosRecibeDesafiosDeUsuario_YElDesafioEstaNoEnLosDelUsuario_DevuelveEseDesafio() {

		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		
		desafiosDeUsuario.add(new DesafioDeUsuario(desafio1 , usuario1));
		proyecto.recibirDesafio(desafio1);
		proyecto.recibirDesafio(desafio2);
		
		List<Desafio> desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		
		assertEquals(1, desafiosSinHacer.size());
		assertTrue(desafiosSinHacer.contains(desafio2));
	}
	

}
