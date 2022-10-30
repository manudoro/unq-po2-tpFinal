package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {
	
	private Proyecto proyecto;
	private Usuario usuario;
	private Muestra muestra;
	private Desafio desafio;
	
	@BeforeEach
	void setUp() {
		this.proyecto = new Proyecto("Recolectar Basura");
		this.usuario  = new Usuario();
		this.muestra = new Muestra();
		this.desafio = new Desafio();
	}

	@Test
	void seVerificaQueUnProyectoConoceSuNombre() {
		
		assertEquals("Recolectar Basura", this.proyecto.getNombre());
	}
	
	@Test
	void cuandoSeCreaUnProyecto_EsteNoTieneCategorias() {
		
		assertFalse(this.proyecto.tieneCategorias());
	}
	
	@Test
	void seVerificaQueSePuedeVincularUnaCategoriaAUnProyecto() {
		this.proyecto.vincularACategoria("Ambiental");
		
		assertTrue(this.proyecto.tieneCategorias());
	}
	
	@Test
	void cuandoSeCreaUnProyecto_EsteNoTieneMuestrasRecolectadas() {
		
		assertFalse(this.proyecto.tieneMuestras());
	}
	
	@Test
	void seVerificaQueSePuedeAgregarUnaMuestraAUnProyecto() {
		this.proyecto.recibirMuestra(this.muestra);
		
		assertTrue(this.proyecto.tieneMuestras());
	}
	
	@Test
	void cuandoSeCreaUnProyecto_EsteNoTieneUsuariosSuscritos() {
		
		assertFalse(this.proyecto.tieneUsuariosSuscritos());
	}
	
	@Test
	void seVerificaQueUnProyectoPuedeSuscribirAUnUsuario() {		
		this.proyecto.suscribirAUsuario(this.usuario);
		
		assertTrue(this.proyecto.tieneUsuariosSuscritos());
	}
	
	@Test
	void cuandoSeCreaUnProyecto_esteNoPoseeDesafios() {
		assertFalse(this.proyecto.tieneDesafios());
	}
	
	@Test
	void seVerificaQueUnProyectoPuedeRecibirDesafios() {
		this.proyecto.recibirDesafio(this.desafio);
		
		assertTrue(this.proyecto.tieneDesafios());
	}
}
