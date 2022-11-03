package ar.edu.unq.poo2.tpfinal.sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class SistemaTest {

	private Sistema sistema;
	private Usuario usuarioSinProyectos;

	@BeforeEach
	void setUp() {
		this.sistema = new Sistema();
		this.usuarioSinProyectos = new Usuario();
	}
	
	@Test
	void seVerificaQueUnSistemaNoRecomiendaNingunDesafioSiElUsuarioNoEstaEnNDesafiooyecto() {
		ArrayList<Desafio> desafiosRecomendados = this.sistema.recomendarDesafios(this.usuarioSinProyectos);
		
		assertTrue(desafiosRecomendados.isEmpty());
	}
	
}
