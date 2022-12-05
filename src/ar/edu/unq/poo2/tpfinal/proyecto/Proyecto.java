package ar.edu.unq.poo2.tpfinal.proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Proyecto {
	
	/* Esta clase modela un proyecto */
	
	private String nombre;
	private String descripcion;
	private List<Usuario> usuariosSuscritos;
	private Set<Categoria> categorias;
	private List<Muestra> muestras;
	private List<Desafio> desafios;
	



	public Proyecto(String name, String description) {
		
		this.nombre = name;
		this.descripcion = description;
		this.usuariosSuscritos = new ArrayList<Usuario>();
		this.categorias = new HashSet<Categoria>();
		this.muestras = new ArrayList<Muestra>();
		this.desafios = new ArrayList<Desafio>();
		
	}


	public List<Usuario> getUsuarios() {
		return usuariosSuscritos;
	}

	public List<Categoria> getCategorias() {
		return new ArrayList(categorias);
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public List<Desafio> getDesafios() {
		return desafios;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void vincularACategoria(Categoria category) {
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
		this.getDesafios().add(challange);
	}
	
	public void recibirMuestra(Muestra unaMuestra) {
		// este metodo permite que el proyeco reciba una muestra.
		if(esNecesaria(unaMuestra)){	
			this.getMuestras().add(unaMuestra);
		}
	}


	public boolean esNecesaria(Muestra unaMuestra) {
		/* indica si la muestra que se recibe por parametro es necesaria almacenar si 
		 * lo necesitan los desafios que posee el proyecto
		 */
		return this.getDesafios().stream().anyMatch(d -> d.correspondeA(unaMuestra));
	}
	
	public boolean contieneCategorias(List<Categoria> categorias2) {
		// este metodo indica si todas categorias dadas se incluyen en las del proyecto.
		List<String> nombres = this.getCategorias().stream().map(c->c.getNombre()).toList();
		return nombres.stream().anyMatch(c -> categorias2.stream().map(cat->cat.getNombre()).toList().contains(c));
	}
	

	public boolean contieneTextoEnNombre(String searchText) {
		return this.getNombre().toUpperCase().contains(searchText.toUpperCase());
	}


	public List<Desafio> desafiosSinParticipacion(List<DesafioDeUsuario> desafiosDeUsuario) {
		List<Desafio> desafiosSinParticipacion = new ArrayList<Desafio>();
		for(Desafio desafio : desafios) {
			agregarSiNoEsta(desafiosDeUsuario, desafiosSinParticipacion, desafio); //
		}
		return desafiosSinParticipacion;
	}


	private void agregarSiNoEsta(List<DesafioDeUsuario> desafiosDeUsuario,
								List<Desafio> desafiosSinParticipacion, Desafio desafio) {
		// Si el desafio dado no se encuentra en los desafiosDeUsuario, entonces
		// se acumula en la lista dada.
		if(!desafio.estaEnLosDesafiosDeUsuario(desafiosDeUsuario)) {
			agregarDesafio(desafiosSinParticipacion, desafio);
		}
	}


	private void agregarDesafio(List<Desafio> desafios, Desafio desafio) {
		// se agrega el desafio dado a la lista de desafios dada por parametro
		desafios.add(desafio);
	}


	public boolean tieneLaMuestra(Muestra muestra) {
		return getMuestras().contains(muestra);
	}


	public boolean tieneUsuarios() {
		return !getUsuarios().isEmpty();
	}


	public boolean tieneCategorias() {
		return !getCategorias().isEmpty();
	}
	
	
}
