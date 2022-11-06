package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

<<<<<<< HEAD
import java.time.LocalDate;
=======

>>>>>>> 1a67fe4ff8df1fca5f22ecfd81f44409a308d397
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.DiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.FinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.IRestriccionTemporal;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
<<<<<<< HEAD
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
=======
>>>>>>> 1a67fe4ff8df1fca5f22ecfd81f44409a308d397
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {

	private Proyecto proyecto;
<<<<<<< HEAD
	private Usuario usuario1 , usuario2;
	private Muestra muestra;
=======
	private Usuario usuario1;
	private Desafio desafio2;
>>>>>>> 1a67fe4ff8df1fca5f22ecfd81f44409a308d397
	private String categoria;
	private Desafio desafio1, desafio2, desafio3;
	private Coordenada punto;
	private IRestriccionTemporal finDeSemana, diaDeSemana;

	
	@BeforeEach
	void setUp(){
		// Se crean instancias de Desafio.
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		IRestriccionTemporal finDeSemana = new FinDeSemana();
		IRestriccionTemporal diaDeSemana = new DiasDeSemana();
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
