package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

class UsuarioTest {

	private Usuario usuario;
	private Dificultad dificultad;
	
	@BeforeEach
	void setUp() {
		this.dificultad = Dificultad.FACIL;
		this.usuario = new Usuario(2, this.dificultad, 10);
	}
	
	@Test
	void cuandoSeCreaUnUsuario_EsteNoParticipaEnNingunProyecto() {
		
		assertFalse(this.usuario.participaEnProyectos());
	}
	
	void seVerificaQueUnUsuarioPuedeParticiparEnAlgunProyecto() {
		this.usuario.participarEnProyecto(this.proyecto);
		
		assertTrue(this.usuario.participarEnProyecto());
	}
	
	void cuandoSeCreaUnUsuario_esteNoTieneMuestrasRecolectadas() {
		assertFalse(this.usuario.tieneMuestrasRecolectadas());
	}
	
	void seVerificaQueUnUsuarioPuedeRecolectarUnaMuestra() {
		Calendar fecha = new GregorianCalendar(2022, 12, 21);
		
		this.usuario.recolectarMuestra(21, 12, fecha);
		
		assertTrue(this.usuario.tieneMuestrasRecolectadas());
	}
	
	void seVerificaQueUnUsuarioPuedeIndicarSusDesafiosCompletados_peroNoCompletoNinguno() { // Completar. Falta que el usuario complete un desafio
		ArrayList<Desafio> desafiosCompletados = this.usuario.desafiosCompletado();
		
		assertTrue(desafiosCompletados.isEmpty());
	}
	
	void seVerificaQueUnUsuarioPuedeIndicarSusDesafiosCompletado_tieneDesafiosCompletados() {
		ArrayList<Desafio> desafiosCompletados = this.usuario.desafiosCompletado();
		
		assertTrue(desafiosCompletados.include(Desafio));
	}
	
	
}
