package ar.edu.unq.poo2.tpfinal.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.FinDeSemana;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Preferencia;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class SistemaTest {

	private Sistema sistema;
	private Usuario usuario;
	private Proyecto proyecto;
	private Desafio desafio;
	private Desafio desafio2;
	private Desafio desafio1;
	private Proyecto proyecto2;
	private IFormaDeRecomendacion preferencia;
	private IFormaDeRecomendacion favorito;
	
	@BeforeEach
	void setUp() {
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		FinDeSemana finDeSemana = new FinDeSemana();
		Dificultad facil = Dificultad.FACIL;
		
		desafio1 = new Desafio(area, 1, facil, 1, finDeSemana);
		desafio2 = new Desafio(area, 2, facil, 2, finDeSemana);
		
		this.sistema = new Sistema();
		this.usuario = new Usuario();
		this.proyecto = new Proyecto("TP_Final", "Contenido para sacarse un 10 :D");
		this.proyecto2 = new Proyecto("TP_Final", "Contenido para sacarse un 9 :D");
		
		this.preferencia = new FormaDeRecomendacionPreferencia();
		this.favorito = new FormaDeRecomendacionFavorito();
	}
	
	@Test
	void seVerificaQueUnSistemaNoRecomiendaNingunDesafioSiElUsuarioNoEstaEnNDesafiooyecto() {
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertTrue(desafiosRecomendados.isEmpty());
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_elSistemaLeRecomiendaLosDesafiosDeEseProyecto() {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);
		
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertEquals(2, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio1));
		assertTrue(desafiosRecomendados.contains(desafio2));
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_YParticipaEnAlMenos1_elSistemaLeRecomiendaLosDesafiosDeEseProyecto_ExcluyendoElQueParticipa() {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);
		usuario.aceptarDesafio(desafio1);
		
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertEquals(1, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio2));
		assertFalse(desafiosRecomendados.contains(desafio1));
	}
	
	@Test
	void cuandoUnUsuarioParticipaEn2Proyecto_ElSistemaLeRecomiendaLosDesafiosDeAmbosProyectos() {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto2.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);
		usuario.participarEnProyecto(proyecto2);
		
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertEquals(2, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio2));
		assertTrue(desafiosRecomendados.contains(desafio1));
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnoDeDosProyectos_ElSistemaLeRecomiendaLosDesafiosDeElProyectoQuePartici() {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto2.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);

		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertEquals(1, desafiosRecomendados.size());
		assertFalse(desafiosRecomendados.contains(desafio2));
		assertTrue(desafiosRecomendados.contains(desafio1));
	}
	
	@Test
	void seVerificaQueUnSistemaRecomiendaDesafiosParaUnUsuario_SegunLaPreferencia(){
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		FinDeSemana finDeSemana = new FinDeSemana();
		Dificultad facil = Dificultad.FACIL;
		Dificultad medio = Dificultad.MEDIO;
		Dificultad muy_dificil = Dificultad.MUY_DIFICIL;
		
		Desafio desafio1 = new Desafio(area, 20, facil, 80, finDeSemana); //<-- 71
		Desafio desafio2 = new Desafio(area, 50, facil, 80, finDeSemana); //<-- 81
		Desafio desafio3 = new Desafio(area, 30, medio, 90, finDeSemana); //<-- 70
		Desafio desafio4 = new Desafio(area, 80, medio, 150, finDeSemana); //<-- 180
		Desafio desafio5 = new Desafio(area, 90, facil, 30, finDeSemana); //<-- 70
		Desafio desafio6 = new Desafio(area, 72, muy_dificil, 180, finDeSemana); // <-- 204
		Desafio desafio7 = new Desafio(area, 31, muy_dificil, 80, finDeSemana); // <-- 63
		Desafio desafio8 = new Desafio(area, 32, medio, 20, finDeSemana); //<-- 2
		
		proyecto.recibirDesafio(desafio1);
		proyecto.recibirDesafio(desafio2);
		proyecto.recibirDesafio(desafio3);
		proyecto.recibirDesafio(desafio4);
		proyecto.recibirDesafio(desafio5);
		proyecto.recibirDesafio(desafio6);
		proyecto.recibirDesafio(desafio7);
		proyecto.recibirDesafio(desafio8);
		
		usuario.participarEnProyecto(proyecto);
		
		usuario.configurarPreferencia(medio, 30, 20);
		
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, preferencia);
		
		assertEquals(5, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio8));
		assertTrue(desafiosRecomendados.contains(desafio7));
		assertTrue(desafiosRecomendados.contains(desafio5));
		assertTrue(desafiosRecomendados.contains(desafio3));
		assertTrue(desafiosRecomendados.contains(desafio1));
		
	}
	
	@Test
	void seVerificaQueUnSistemaRecomiendaDesafiosParaUnUsuario_SegunElFavoritismo(){
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		FinDeSemana finDeSemana = new FinDeSemana();
		Dificultad facil = Dificultad.FACIL;
		Dificultad medio = Dificultad.MEDIO;
		Dificultad muy_dificil = Dificultad.MUY_DIFICIL;
		
		Desafio desafio1 = new Desafio(area, 20, facil, 80, finDeSemana); //<-- 71
		Desafio desafio2 = new Desafio(area, 50, facil, 80, finDeSemana); //<-- 81
		Desafio desafio3 = new Desafio(area, 30, medio, 90, finDeSemana); //<-- 70
		Desafio desafio4 = new Desafio(area, 80, medio, 150, finDeSemana); //<-- 180
		Desafio desafio5 = new Desafio(area, 90, facil, 30, finDeSemana); //<-- 70
		Desafio desafio6 = new Desafio(area, 72, muy_dificil, 180, finDeSemana); // <-- 204
		Desafio desafio7 = new Desafio(area, 31, muy_dificil, 80, finDeSemana); // <-- 63
		Desafio desafio8 = new Desafio(area, 32, medio, 20, finDeSemana); //<-- 2
		
		proyecto.recibirDesafio(desafio1);
		proyecto.recibirDesafio(desafio2);
		proyecto.recibirDesafio(desafio3);
		proyecto.recibirDesafio(desafio4);
		proyecto.recibirDesafio(desafio5);
		proyecto.recibirDesafio(desafio6);
		proyecto.recibirDesafio(desafio7);
		proyecto.recibirDesafio(desafio8);
		
		usuario.participarEnProyecto(proyecto);
		
		usuario.configurarPreferencia(medio, 30, 20);
		
		List<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario, favorito);
		
		assertEquals(5, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio8));
		assertTrue(desafiosRecomendados.contains(desafio7));
		assertTrue(desafiosRecomendados.contains(desafio5));
		assertTrue(desafiosRecomendados.contains(desafio3));
		assertTrue(desafiosRecomendados.contains(desafio1));
		
	}
}
