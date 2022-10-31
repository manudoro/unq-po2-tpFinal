package ar.edu.unq.poo2.tpfinal.proyecto;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class ProyectoTest {

	Proyecto proyecto;
	Usuario usuario1 , usuario2;
	Muestra muestra;
	Desafio desafio;
	String categoria;
	
	@BeforeEach
	void setUp() throws Exception {
		
		proyecto = new Proyecto("AquatiWord", "Cs.Natural");
		usuario1 = mock(Usuario.class);
		categoria = "Botanica";
	}

	@Test
	void testSeVerificaQueSePuedeSuscribirUnUsuarioAUnProyecto()	 {
		proyecto.suscribirUsuario(usuario1);
		assertEquals(proyecto.getUsuarios().size() , 1);	
	}

	@Test 
	void testSeVerificaQueUnProyectoPuedeDesuscribirUsuarios(){
		proyecto.suscribirUsuario(usuario1);
		proyecto.desuscribirUsuario(usuario1);
		assertEquals(proyecto.getUsuarios().size(), 0);
	}
	
	@Test
	
	void testSeVerificaQueSePuedeVincularUnaCategoriaAUnProyecto() {
		proyecto.vincularACategoria(categoria);
		assertEquals(proyecto.getCategorias().size() , 1);	
		
	}

}
