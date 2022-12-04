package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.IRestriccionTemporal;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionDiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionFinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {

	private Proyecto proyecto;

	private Usuario usuario;
	private Muestra muestra;
	private Categoria categoria;
	private Desafio desafio;
	private DesafioDeUsuario desafioDeUsuario;
	
	@BeforeEach
	void setUp(){
		proyecto = new Proyecto("AquatiWord", "Cs.Natural");
		usuario = mock(Usuario.class);
		categoria = mock(Categoria.class);
		desafio = mock(Desafio.class);
		desafioDeUsuario = mock(DesafioDeUsuario.class);
	}

	@Test
	void testSeVerificaQueSePuedeSuscribirUnUsuarioAUnProyecto()	 {
		proyecto.suscribirUsuario(usuario);
		assertTrue(proyecto.tieneUsuarios());
	}

	@Test 
	void testSeVerificaQueUnProyectoPuedeDesuscribirUsuarios(){
		proyecto.suscribirUsuario(usuario);
		proyecto.desuscribirUsuario(usuario);
		assertFalse(proyecto.tieneUsuarios());
	}
	
	@Test
	
	void testSeVerificaQueSePuedeVincularUnaCategoriaAUnProyecto() {
		proyecto.vincularACategoria(categoria);
		assertTrue(proyecto.tieneCategorias());	
		
	}
	
	@Test
	void cuandoUnProyectoQueNoPoseeDesafiosRecibeDesafiosDeUsuario_NoDevuelveNada() {
		List<Desafio> desafiosSinHacer;
		List<DesafioDeUsuario> desafiosDeUsuario;
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		assertTrue(desafiosSinHacer.isEmpty());
	}
	
	
 	@Test
	void cuandoUnProyectoQuePoseeDesafiosRecibeDesafiosDeUsuario_YElDesafioEstaEnLosDelUsuario_NoDevuelveNada() {
		List<Desafio> desafiosSinHacer;
		List<DesafioDeUsuario> desafiosDeUsuario;
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		proyecto.recibirDesafio(desafio);
		when(desafio.estaEnLosDesafiosDeUsuario(desafiosDeUsuario)).thenReturn(true); //
		desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		assertTrue(desafiosSinHacer.isEmpty());
	}
	
	@Test
	void cuandoUnProyectoQuePoseeDesafiosRecibeDesafiosDeUsuario_YElDesafioEstaNoEnLosDelUsuario_DevuelveEseDesafio() {
		List<Desafio> desafiosSinHacer;
		List<DesafioDeUsuario> desafiosDeUsuario;
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		proyecto.recibirDesafio(desafio);
		when(desafio.estaEnLosDesafiosDeUsuario(desafiosDeUsuario)).thenReturn(false);
		desafiosSinHacer = proyecto.desafiosSinParticipacion(desafiosDeUsuario);
		assertFalse(desafiosSinHacer.isEmpty());
	}
	
	@Test
	void cuandoUnProyectoRecibeUnaMuestraYAlgunDesafioDeLaMuestraLaRequiere_ésteLaAlmacena() {
		proyecto.recibirDesafio(desafio);
		when(proyecto.esNecesaria(muestra)).thenReturn(true);
		proyecto.recibirMuestra(muestra);
		assertTrue(proyecto.tieneLaMuestra(muestra));
	}
	
	@Test
	void cuandoUnProyectoRecibeUnaMuestraYAlgunDesafioDeLaMuestraNoLaRequiere_ésteNoLaAlmacena() {
		proyecto.recibirDesafio(desafio);
		when(proyecto.esNecesaria(muestra)).thenReturn(false);
		proyecto.recibirMuestra(muestra);
		assertFalse(proyecto.tieneLaMuestra(muestra));
	}
	
}
