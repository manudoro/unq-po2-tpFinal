package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionTemporal;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class UsuarioTest {

	Proyecto proyecto;
	Usuario usuario1, usuario2;
	Muestra muestra;
	DesafioDeUsuario desafioUsuario;
	Desafio desafio;
	
	@BeforeEach
	void setUp() throws Exception {
	usuario1 = new Usuario();
	proyecto = new Proyecto("Programmin", "Cs.Tecnologhy");
	muestra = mock(Muestra.class);
	desafioUsuario = mock(DesafioDeUsuario.class);
	
	Dificultad facil = Dificultad.FACIL;
	LocalDate fecha = LocalDate.of(2020, 5, 19);
	LocalTime tiempoDesde = LocalTime.of(7, 30);
	LocalTime tiempoHasta = LocalTime.of(19, 30);
	Coordenada punto = new Coordenada(5, 4);
	Area area = new Area(punto, 5);
	RestriccionTemporal restriccionTemporal = new RestriccionTemporal(fecha, tiempoDesde, tiempoHasta);
	
	this.desafio = new Desafio(area, 2, facil, 5, restriccionTemporal);
	
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
	void testCuandoUnUsuarioRecolectaUnaMuestraYTieneDesafiosQueNecesitanEsaMuestra_SeActualizanEsosDesafios() {
		
	}
	
	
	
}
