package ar.edu.unq.poo2.tpfinal.recomendacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionFinDeSemana;
import ar.edu.unq.poo2.tpfinal.filtro.Sistema;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.recomendacion.FormaDeRecomendacionFavorito;
import ar.edu.unq.poo2.tpfinal.recomendacion.FormaDeRecomendacionPreferencia;
import ar.edu.unq.poo2.tpfinal.recomendacion.IFormaDeRecomendacion;
import ar.edu.unq.poo2.tpfinal.usuario.Preferencia;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class RecomendacionTest {

	private Usuario usuario;
	private Proyecto proyecto;
	private Desafio desafio2;
	private Desafio desafio1;
	private Proyecto proyecto2;
	private IFormaDeRecomendacion preferencia;
	private IFormaDeRecomendacion favorito;
	
	@BeforeEach
	void setUp() {
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		RestriccionFinDeSemana finDeSemana = new RestriccionFinDeSemana();
		Dificultad facil = Dificultad.FACIL;
		
		desafio1 = new Desafio(area, 1, facil, 1, finDeSemana);
		desafio2 = new Desafio(area, 2, facil, 2, finDeSemana);
		
		this.usuario = new Usuario(new Preferencia());
		this.proyecto = new Proyecto("TP_Final", "Contenido para sacarse un 10 :D");
		this.proyecto2 = new Proyecto("TP_Final", "Contenido para sacarse un 9 :D");
		
		this.preferencia = new FormaDeRecomendacionPreferencia();
		this.favorito = new FormaDeRecomendacionFavorito();
	}
	
	@Test
	void seVerificaQueUnSistemaNoRecomiendaNingunDesafioSiElUsuarioNoEstaEnNDesafiooyecto() {
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
		assertTrue(desafiosRecomendados.isEmpty());
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_elSistemaLeRecomiendaLosDesafiosDeEseProyecto() {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);
		
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
		assertEquals(2, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio1));
		assertTrue(desafiosRecomendados.contains(desafio2));
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_YParticipaEnAlMenos1_elSistemaLeRecomiendaLosDesafiosDeEseProyecto_ExcluyendoElQueParticipa() throws Exception {
		// El proyecto recibe desafios
		proyecto.recibirDesafio(desafio1); 
		proyecto.recibirDesafio(desafio2); 
		
		// Para que el sistema le recomiende desafios, el usuario debe participar en el proyecto
		usuario.participarEnProyecto(proyecto);
		usuario.aceptarDesafio(desafio1);
		
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
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
		
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
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

		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
		assertEquals(1, desafiosRecomendados.size());
		assertFalse(desafiosRecomendados.contains(desafio2));
		assertTrue(desafiosRecomendados.contains(desafio1));
	}
	
	@Test
	void seVerificaQueUnSistemaRecomiendaDesafiosParaUnUsuario_SegunLaPreferencia(){
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		RestriccionFinDeSemana finDeSemana = new RestriccionFinDeSemana();
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
		
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(preferencia);
		
		assertEquals(5, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio8));
		assertTrue(desafiosRecomendados.contains(desafio7));
		assertTrue(desafiosRecomendados.contains(desafio5));
		assertTrue(desafiosRecomendados.contains(desafio3));
		assertTrue(desafiosRecomendados.contains(desafio1));
		
	}
	
	@Test
	void seVerificaQueUnSistemaRecomiendaDesafiosParaUnUsuario_SegunElFavoritismo() throws Exception{
		
		Coordenada punto = new Coordenada(5, 4);
		Area area = new Area(punto, 5);
		RestriccionFinDeSemana finDeSemana = new RestriccionFinDeSemana();
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
		Desafio desafio9 = new Desafio(area, 30, medio, 30, finDeSemana); //<-- Desafio para el usuario	
		
		proyecto.recibirDesafio(desafio1);
		proyecto.recibirDesafio(desafio2);
		proyecto.recibirDesafio(desafio3);
		proyecto.recibirDesafio(desafio4);
		proyecto.recibirDesafio(desafio5);
		proyecto.recibirDesafio(desafio6);
		proyecto.recibirDesafio(desafio7);
		proyecto.recibirDesafio(desafio8);
		proyecto.recibirDesafio(desafio9);
		
		usuario.participarEnProyecto(proyecto);
		usuario.aceptarDesafio(desafio9);
		
		usuario.configurarPreferencia(medio, 30, 20);
		
		List<Desafio> desafiosRecomendados = usuario.recomendarDesafios(favorito);
		
		assertEquals(5, desafiosRecomendados.size());
		assertTrue(desafiosRecomendados.contains(desafio8));
		assertTrue(desafiosRecomendados.contains(desafio7));
		assertTrue(desafiosRecomendados.contains(desafio5));
		assertTrue(desafiosRecomendados.contains(desafio3));
		assertTrue(desafiosRecomendados.contains(desafio1));
		
	}
}
