package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Area;
import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionDiasDeSemana;
import ar.edu.unq.poo2.tpfinal.desafio.Dificultad;
import ar.edu.unq.poo2.tpfinal.desafio.RestriccionFinDeSemana;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

class UsuarioTest {


	private Proyecto proyecto;
	private Usuario usuario1;
	private Muestra muestra , muestra1;
	private DesafioDeUsuario desafioUsuario;
	private Desafio desafio;
	private DesafioDeUsuario desafioDeUsuario;
	private RestriccionFinDeSemana finDeSemana;
	private Desafio desafio2;

	RestriccionDiasDeSemana diasDeSemana;
	
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
	finDeSemana = new RestriccionFinDeSemana();
	diasDeSemana = new RestriccionDiasDeSemana();
	this.desafio = new Desafio(area, 1, facil, 5,finDeSemana);
	this.desafio2 = new Desafio(area, 1, facil, 5,diasDeSemana);

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

	void seVerificaQueUnUsuarioNoParticipaEnDesafiosSiNoEstanEnSusProyectos(){
		assertFalse(usuario1.desafiosSinHacer().contains(desafio));
		
	}
	

	@Test
	void seVerificaQueUnUsuarioParticipaEnDesafiosSiEstanEnSusProyectos(){
		this.usuario1.participarEnProyecto(proyecto);
		this.proyecto.recibirDesafio(desafio);
		assertTrue(usuario1.desafiosSinHacer().contains(desafio));
		
	}
	
	@Test 
	void seObtieneElPorcentajeDeCompletitudDeUnDesafio() {
		this.usuario1.participarEnProyecto(proyecto);
		this.proyecto.recibirDesafio(desafio);
		this.usuario1.aceptarDesafio(desafio);
		this.usuario1.obtenerMuestra(muestra1);
		assertEquals(100, usuario1.getPorcentajeDeCompletitud(desafio));

	}


	@Test
	void seObtieneElPromedioGeneralDePorcentajeDeDesafios() {
		this.usuario1.participarEnProyecto(proyecto);
		this.proyecto.recibirDesafio(desafio);
		this.proyecto.recibirDesafio(desafio2);
		this.usuario1.aceptarDesafio(desafio);
		this.usuario1.aceptarDesafio(desafio2);
		this.usuario1.obtenerMuestra(muestra1);
		assertEquals(50.0, usuario1.getPorcentajeGeneralDeCompletitud());
	}
		
	@Test

	void seVerificaQueUnUsuarioPuedeModificarSuPreferencia() {
		usuario1.configurarPreferencia(Dificultad.FACIL, 30, 20);
		
		assertEquals(Dificultad.FACIL, usuario1.getPreferencia().getDificultad());
		assertEquals(30, usuario1.getPreferencia().getRecompenzaPreferida());
		assertEquals(20, usuario1.getPreferencia().getCantidadDeMuestras());


	}
	
	@Test
	void cuandoUnUsuarioQuiereElMejorDesafio_DevuelveElQueMasLeGusto(){
		proyecto.recibirDesafio(desafio);
		proyecto.recibirDesafio(desafio2);
		usuario1.participarEnProyecto(proyecto);
		
		usuario1.aceptarDesafio(desafio);
		usuario1.aceptarDesafio(desafio2);
		
		Desafio desafio = usuario1.mejorDesafio();
		
		assertEquals(this.desafio, desafio);
		
	}
	
	@Test
	void seVerificaQueUnUsuarioPuedeCalificarUnDesafio() {
		
		this.desafioDeUsuario = new DesafioDeUsuario(desafio , usuario1);
		
		
		usuario1.calificarDesafio(desafioDeUsuario, Valoracion.EXELENTE);
		assertEquals(Valoracion.EXELENTE, desafioDeUsuario.getGustoDeUsuario());
	}
	
}
