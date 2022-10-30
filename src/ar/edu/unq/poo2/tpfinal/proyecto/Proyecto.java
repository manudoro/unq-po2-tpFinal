package ar.edu.unq.poo2.tpfinal.proyecto;

import java.util.*;

import ar.edu.unq.poo2.tpfinal.desafio.*;
import ar.edu.unq.poo2.tpfinal.muestra.*;
import ar.edu.unq.poo2.tpfinal.usuario.*;

public class Proyecto {

	private String nombre;
	private List<String> categorias;
	private List<Muestra> muestras;
	private List<Usuario> usuariosSuscritos;
	private List<Desafio> desafios;
	
	public Proyecto(String tituloDeProyecto) {
		this.nombre = tituloDeProyecto;
		this.categorias = new ArrayList<String>();
		this.muestras = new ArrayList<Muestra>();
		this.usuariosSuscritos = new ArrayList<Usuario>();
		this.desafios = new ArrayList<Desafio>();
	}

	public String getNombre() {
		return nombre;
	}

	public boolean tieneCategorias() {
		boolean resultado = !this.categorias.isEmpty();
		
		return resultado;
	}

	public void vincularACategoria(String string) {
		this.categorias.add(string);
	}

	public boolean tieneMuestras() {
		boolean resultado = !this.muestras.isEmpty();
		
		return resultado;
	}

	public void recibirMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}

	public boolean tieneUsuariosSuscritos() {
		boolean resultado = !this.usuariosSuscritos.isEmpty();
		
		return resultado;
	}

	public void suscribirAUsuario(Usuario usuario) {
		this.usuariosSuscritos.add(usuario);
	}

	public boolean tieneDesafios() {
		boolean resultado = !this.desafios.isEmpty();
		
		return resultado;
	}

	public void recibirDesafio(Desafio desafio) {
		this.desafios.add(desafio);
		
	}

}
