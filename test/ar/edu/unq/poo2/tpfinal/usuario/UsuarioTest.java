package ar.edu.unq.poo2.tpfinal.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

class UsuarioTest {

	Proyecto proyecto;
	Usuario usuario1, usuario2;
	Muestra muestra;
	Desafio desafio;
	
	@BeforeEach
	void setUp() throws Exception {
	usuario1 = new Usuario();
	usuario2=  new Usuario();
	proyecto = new Proyecto("Programmin", "Cs.Tecnologhy");
	muestra = mock(Muestra.class);
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
	
}
