package ar.edu.unq.poo2.tpfinal.usuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.proyecto.Proyecto;

	

public class Usuario {
	
	/* Se  modela un usuario */
	
	private List<Muestra> muestrasRecolectadas;
	private ArrayList<DesafioDeUsuario> desafios;
	private List<Proyecto> proyectos;
	private List<DesafioDeUsuario> desafiosCompletos;
	
	public Usuario() {
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.desafios = new ArrayList<DesafioDeUsuario>();
		this.proyectos = new ArrayList<Proyecto>();
		this.desafiosCompletos = new ArrayList<DesafioDeUsuario>();
	}

	public List<Muestra> getMuestrasRecolectadas() {
		// Muestras que recolecto un usuario
		return muestrasRecolectadas;
	}


	public List<DesafioDeUsuario> getDesafiosDeUsuario() {
		// Desafios en los que participa un usuario.
		return desafios;
	}
	
	public List<DesafioDeUsuario> getDesafiosCompletos() {
		return desafiosCompletos;
	}

	public void participarEnProyecto(Proyecto proyecto) {
		// Este metodo permite, a un usuario, participar en un proyecto
		proyecto.suscribirUsuario(this);
		this.proyectos.add(proyecto);
	}
	
	public void dejarDeParticiparEnProyecto(Proyecto proyecto) {
		// Este metodo permite, a un usuario, dejar de participar en un proyecto
		proyecto.desuscribirUsuario(this);
		this.proyectos.remove(proyecto);
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void agregarDesafio(Desafio desafio) {
		if(this.proyectos.stream().anyMatch(p -> p.getDesafios().contains(desafio))) {	
		desafio.asignarDesafioDeUsuario(this);
		}
	}

	public void agregarDesafioDeUsuario(DesafioDeUsuario desafioUsuario) {
		this.desafios.add(desafioUsuario);
		
	}

	public boolean participaEnProyectos() {
		return this.proyectos.isEmpty();
	}

	public ArrayList<Desafio> desafiosSinHacer() { //Corregir
		ArrayList<Desafio> desafiosSinHacer = new ArrayList<Desafio>();
		proyectos.stream().forEach(proyecto -> desafiosSinHacer.addAll(proyecto.desafiosSinParticipacion(desafios)));
		
		return desafiosSinHacer;
	}
	

	public void agregarDesafiosCompletos(DesafioDeUsuario desafioDeUsuario){
		this.desafiosCompletos.add(desafioDeUsuario);
	}
	
	public Double getPorcentajeGeneralDeCompletitud() {
		Double sumaTotal = this.getDesafiosDeUsuario().stream().mapToDouble(d-> d.getPorcentajeDeCompletitud()).sum();
		return sumaTotal / (this.getDesafiosDeUsuario().size());
		
	}
	
	public void obtenerMuestra(Muestra muestra) {
		this.desafios.stream().forEach(d -> d.recibirMuestra(muestra));
		
	}

	public void enviarMuestraAProyectos(Muestra muestra) {
		this.getProyectos().stream().forEach(p -> p.recibirMuestra(muestra));
		
	}
	
	
}

