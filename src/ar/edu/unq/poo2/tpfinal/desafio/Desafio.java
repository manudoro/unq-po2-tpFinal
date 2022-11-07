package ar.edu.unq.poo2.tpfinal.desafio;

import java.util.ArrayList;


import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Preferencia;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Desafio {
	
	private Area area;
	private int cantidadDeMuestrasARecolectar;
	private Dificultad dificultad;
	private int recompensa;
	private IRestriccionTemporal restriccionTemporal;
	
	public Desafio(Area area, int cantidadDeMuestrasARecolectar, Dificultad dificultad, int recompensa, IRestriccionTemporal restriccionTemporal) {
		this.area = area;
		this.cantidadDeMuestrasARecolectar = cantidadDeMuestrasARecolectar;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.restriccionTemporal = restriccionTemporal;
	}

	public Area getArea() {
		return area;
	}

	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public IRestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;

	}

	public void asignarDesafioDeUsuario(Usuario usuario) {
		DesafioDeUsuario desafio = new DesafioDeUsuario(this , usuario);
		usuario.agregarDesafioDeUsuario(desafio);
		//double dispach
		
	}

	
	public boolean estaEnElArea(Muestra muestra) {
		return this.area.estaDentro(muestra);
	}

	public boolean estaEnLosDesafiosDeUsuario(List<DesafioDeUsuario> desafiosDeUsuario) {
		return desafiosDeUsuario.stream().anyMatch((DesafioDeUsuario desafioDeUsuario) -> desafioDeUsuario.contieneAlDesafio(this));
	}


	public boolean correspondeA(Muestra sample) {
		
		return estaEnElArea(sample) && correspondeARestriccion(sample);
	}

	public boolean correspondeARestriccion(Muestra muestra) {
		return this.getRestriccionTemporal().validar(muestra.getFechaDeRecoleccion());

	}


	public Integer valorDeCoincidenciaConPreferencia(Preferencia preferencia) {
		int valorDeDificultad = dificultad.getValorDeDificultad();
		int valorDePreferencia = preferencia.calcularCoincidencia(valorDeDificultad, recompensa, cantidadDeMuestrasARecolectar);
		
		return valorDePreferencia;
	}
}
