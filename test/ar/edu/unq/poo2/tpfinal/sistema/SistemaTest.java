package ar.edu.unq.poo2.tpfinal.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class SistemaTest {

	private Sistema sistema;
	private Usuario usuario;
	private Proyecto proyecto;
	private Desafio desafio;

	@BeforeEach
	void setUp() {
		this.sistema = new Sistema();
		this.usuario = new Usuario();
		this.desafio = mock(Desafio.class);
		this.proyecto = mock(Proyecto.class);
	}
	
	@Test
	void seVerificaQueUnSistemaNoRecomiendaNingunDesafioSiElUsuarioNoEstaEnNDesafiooyecto() {
		ArrayList<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario);
		
		assertTrue(desafiosRecomendados.isEmpty());
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_elSistemaLeRecomiendaLosDesafiosDeEseProyecto() {
		proyecto.recibirDesafio(desafio);
		usuario.participarEnProyecto(proyecto);
		
		ArrayList<Desafio> desafiosRecomendados = sistema.recomendarDesafios(usuario);
		
		assertFalse(desafiosRecomendados.isEmpty());
	}
}
