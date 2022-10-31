package ar.edu.unq.poo2.tpfinal.usuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

	

public class Usuario {
	
	/* Se  modela un usuario */
	
	private List<Muestra> muestrasRecolectadas;
	private List<Desafio> desafios;
	private List<Proyecto> proyectos;
	
	public Usuario() {
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.desafios = new ArrayList<Desafio>();
		this.proyectos = new ArrayList<Proyecto>();
	}

	public List<Muestra> getMuestrasRecolectadas() {
		// Muestras que recolecto un usuario
		return muestrasRecolectadas;
	}


	public List<Desafio> getDesafios() {
		// Desafios en los que participa un usuario.
		return desafios;
	}


	public void participarEnProyecto(Proyecto proyecto) {
		// Este metodo permite, a un usuario, participar en un proyecto
		proyecto.suscribirUsuario(this);
	}
	
	public void dejarDeParticiparEnProyecto(Proyecto proyecto) {
		// Este metodo permite, a un usuario, dejar de participar en un proyecto
		proyecto.desuscribirUsuario(this);
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}
	
}

