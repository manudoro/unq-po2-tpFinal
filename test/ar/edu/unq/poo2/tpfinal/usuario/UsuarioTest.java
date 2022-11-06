package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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

class UsuarioTest {

	Proyecto proyecto;
	Usuario usuario1, usuario2;
	Muestra muestra , muestra1;
	DesafioDeUsuario desafioUsuario;
	Desafio desafio;
	DesafioDeUsuario desafioDeUsuario;
	FinDeSemana finDeSemana;
	
	@BeforeEach
	void setUp() throws Exception {
	usuario1 = new Usuario();
	proyecto = new Proyecto("Programmin", "Cs.Tecnologhy");
	LocalDate fecha = LocalDate.of(2022, 11, 12);
	LocalDate fecha1 = LocalDate.of(2022, 11, 19);
	Coordenada punto2 = new Coordenada(15, 15);
	muestra = new Muestra(punto2,fecha);
	muestra1 = new Muestra(punto2,fecha1);
	Dificultad facil = Dificultad.FACIL;
	Area area = new Area(punto2, 5);
	finDeSemana = new FinDeSemana();
	this.desafio = new Desafio(area, 1, facil, 5,finDeSemana);
	this.desafioDeUsuario = new DesafioDeUsuario(desafio , usuario1);
	}

	@Test
	void cuandoSeCreaUnUsuario_EsteNoParticipaEnNingunProyecto() {
	
		assertTrue(usuario1.getProyectos().isEmpty());  //Hay que ver en cuantos proyectos esta el usuario. No cuantos  usuarios tiene el proyecto
	}
	
	@Test
	void testSeVerificaQueUnUsuarioPuedeParticiparEnUnProyecto() {
	
		usuario1.participarEnProyecto(proyecto);
		assertFalse(usuario1.getProyectos().isEmpty());  //Hay que ver en cuantos proyectos esta el usuario. No cuantos  usuarios tiene el proyecto
	}

	@Test
	void testSeVerificaQueUnUsuarioPuedeDejarDeParticiparEnUnProyecto() {
		
		usuario1.participarEnProyecto(proyecto);
		usuario1.dejarDeParticiparEnProyecto(proyecto);
		assertTrue(usuario1.getProyectos().isEmpty()); // Idem anterior
	}

	
	@Test
	void testSeVerificaQueUnUsuarioNoPoseeDesafrios() {
		assertTrue(this.usuario1.getDesafiosDeUsuario().isEmpty());
	}
	
	@Test
	void testSeVerificaQueUnUsuarioRecibeUnDesafio() {
	//	usuario1.agregarDesafio(desafio);
		usuario1.agregarDesafioDeUsuario(desafioUsuario);
		assertFalse(this.usuario1.getDesafiosDeUsuario().isEmpty());
	}
	
	@Test
	void testSeVerificaQueUnUsuarioPuedeRecibirUnDesafioDeUsuario() {
		usuario1.agregarDesafioDeUsuario(desafioUsuario);
		assertFalse(this.usuario1.getDesafiosDeUsuario().isEmpty());
	}
	
	
	@Test 
	
	void testVerificarCuandoUnUsuarioTerminaUnDesafioQueEsteSeSumaAsuListaDeDesafiosCompletos() {
		this.desafioDeUsuario.recibirMuestra(muestra);
		assertEquals(1 , this.usuario1.getDesafiosCompletos().size());
	
	}
	
	@Test
	void testSeVerificaQueAUnUsuarioSeLePuedePreguntarLosDesafiosQueNoParticipaHacer() {
		Desafio desafio = mock(Desafio.class);
		
		proyecto.recibirDesafio(desafio);
		usuario1.participarEnProyecto(proyecto);
		ArrayList<Desafio> desafiosSinHacer = usuario1.desafiosSinHacer();
		
		assertTrue(desafiosSinHacer.contains(desafio));
		
	}
	
	@Test
	void seVerificaQueUnUsuarioPuedeModificarSuPreferencia() {
		usuario1.configurarPreferencia(Dificultad.FACIL, 30, 20);
		
		assertEquals(Dificultad.FACIL, usuario1.getPreferencia().getDificultad());
		assertEquals(30, usuario1.getPreferencia().getRecompenzaPreferida());
		assertEquals(20, usuario1.getPreferencia().getCantidadDeMuestras());
	}
}
