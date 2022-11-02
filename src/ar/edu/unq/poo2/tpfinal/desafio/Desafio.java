package ar.edu.unq.poo2.tpfinal.desafio;

import ar.edu.unq.poo2.tpfinal.desafiodeusuario.DesafioDeUsuario;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class Desafio {
	private Area area;
	private int cantidadDeMuestrasARecolectar;
	private Dificultad dificultad;
	private int recompensa;
	private RestriccionTemporal restriccionTemporal;
	
	public Desafio(Area area, int cantidadDeMuestrasARecolectar, Dificultad dificultad, int recompensa, RestriccionTemporal restriccionTemporal) {
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

	public RestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;

	}

	public void asignarDesafioDeUsuario(Usuario usuario) {
		DesafioDeUsuario desafio = new DesafioDeUsuario(this);
		usuario.agregarDesafioDeUsuario(desafio);
		//double dispach
		
	}
	
	public int diferenciaDeLongitudDeDesafioYMuestra(Muestra muestra) {
		return this.getArea().diferenciaDeLongitudConMuestra(muestra);
	}

	public int diferenciaDeLatitudDeDesafioYMuestra(Muestra muestra) {
		return this.getArea().diferenciaDeLatitudConMuestra(muestra);
	} 
	
	public boolean estanLasDistanciasDentroDelArea(int resultadoLatitud, int resultadoLongitud) {
		return this.getArea().estanLasDistanciasDentroDelRadio(resultadoLatitud, resultadoLongitud);
	}
	
}
