package ar.edu.unq.poo2.tpfinal.sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class SistemaTest {

	private Sistema sistema;
	private Usuario usuario;

	@BeforeEach
	void setUp() {
		this.sistema = new Sistema();
		this.usuario = new Usuario();
	}
	
	@Test
	void seVerificaQueUnSistemaNoRecomiendaNingunDesafioSiElUsuarioNoEstaEnNDesafiooyecto() {
		ArrayList<Desafio> desafiosRecomendados = this.sistema.recomendarDesafios(this.usuario);
		
		assertTrue(desafiosRecomendados.isEmpty());
	}
	
	@Test
	void cuandoUnUsuarioParticipaEnUnProyecto_elSistemaLeRecomiendaEseDesafio() {
		ArrayList<Desafio> desafiosRecomendados = this.sistema.recomendarDesafios(this.usuario);
		
		assertFalse(desafiosRecomendados.isEmpty());
	}
}
