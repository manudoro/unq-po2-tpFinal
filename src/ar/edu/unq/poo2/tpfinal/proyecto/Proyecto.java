package ar.edu.unq.poo2.tpfinal.proyecto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Proyecto {
	
	/* Esta clase modela un proyecto */
	
	private String nombre;
	private String descripcion;
	private List<Usuario> usuariosSuscritos;
	private Set<String> categorias;
	private List<Muestra> muestras;
	private List<Desafio> desafios;
	



	public Proyecto(String name, String description) {
		
		this.nombre = name;
		this.descripcion = description;
		this.usuariosSuscritos = new ArrayList<Usuario>();
		this.categorias = new HashSet<String>();
		this.muestras = new ArrayList<Muestra>();
		this.desafios = new ArrayList<Desafio>();
		
	}


	public List<Usuario> getUsuarios() {
		return usuariosSuscritos;
	}

	public List<String> getCategorias() {
		return new ArrayList(categorias);
	}
	
	public List<Muestra> getSamples() {
		return muestras;
	}
	public List<Desafio> getChallanges() {
		return desafios;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void vincularACategoria(String category) {
		// este metodo permite, a un proyecto, vincularlo con una categoria nueva
		this.categorias.add(category);
	}
	
	
	
	public void suscribirUsuario(Usuario user) {
		// este metodo permite, a un proyecto, suscribir a un ussuario
		this.getUsuarios().add(user);
	}
	
	public void desuscribirUsuario(Usuario user) {
		// este metodo permite, a un proyecto, desuscribir a un usuario
		this.getUsuarios().remove(user);
	}
	
	public void recibirDesafio(Desafio challange) {
		//  este metodo permite que el proyecto reciba un desafio.
		this.getChallanges().add(challange);
	}
	
	public void recibirMuestra(Muestra sample) {
		// este metodo permite que el proyeco reciba una muestra.
		this.getSamples().add(sample);
	}
	
	
	
	
	
	
	
	
}
