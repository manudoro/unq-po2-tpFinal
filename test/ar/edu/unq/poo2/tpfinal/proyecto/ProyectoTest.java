package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionDiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionFinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.IRestriccionTemporal;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;

import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {

	private Proyecto proyecto;

	private Usuario usuario1;
	private Muestra muestra;
	private String categoria;
	private Desafio desafio1, desafio2, desafio3;

	
	@BeforeEach
	void setUp(){
		// Se crean instancias de Desafio.
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		IRestriccionTemporal finDeSemana = new RestriccionFinDeSemana();
		IRestriccionTemporal diaDeSemana = new RestriccionDiasDeSemana();
		Dificultad facil = Dificultad.FACIL;
		
		desafio1 = new Desafio(area, 1, facil, 1, finDeSemana);
		desafio2 = new Desafio(area, 2, facil, 2, finDeSemana);
		desafio3 = new Desafio(area, 2, facil, 2, diaDeSemana);
		
		proyecto = new Proyecto("AquatiWord", "Cs.Natural");
		usuario1 = mock(Usuario.class);
		categoria = "Botanica";
		
		LocalDate fecha = LocalDate.of(2022, 11, 12);
		muestra = new Muestra(punto, fecha);
		
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
	
	@Test
	void unDesafioRecibeUnaMuestraSiEsValidaParaAlgunoDeSusDesafios() {
		proyecto.recibirDesafio(desafio1);
		proyecto.recibirDesafio(desafio2);
		proyecto.recibirMuestra(muestra);
		assertTrue(proyecto.getMuestras().contains(muestra));

	}
	
	@Test
	void unDesafioNoRecibeUnaMuestraSiNoEsValidaParaAlgunoDeSusDesafios() {
		proyecto.recibirDesafio(desafio3);
		proyecto.recibirMuestra(muestra);
		assertFalse(proyecto.getMuestras().contains(muestra));

	}
	
}
