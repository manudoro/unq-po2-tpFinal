package ar.edu.unq.poo2.tpfinal.desafio;

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
		DesafioDeUsuario desafio = new DesafioDeUsuario(this);
		usuario.agregarDesafioDeUsuario(desafio);
		//double dispach
		
	}

	
	public boolean estaEnElArea(Muestra muestra) {
		return this.area.estaDentro(muestra);
	}



	public Integer getCoincidencia(Preferencia preferencia) {
		int diferenciaDificultad = Math.abs(preferencia.getDificultad() - this.getDificultad().getValorDeDificultad());
		int diferenciaRecompensa = Math.abs(preferencia.getRecompensaPreferida() - this.getRecompensa());
		int diferenciaMuestras = Math.abs(preferencia.getCantidadMuestras() - this.getCantidadMuestras());
		return diferenciaDificultad + diferenciaRecompensa + diferenciaMuestras;
	}

	private int getCantidadMuestras() {
		// TODO Auto-generated method stub
		return this.cantidadDeMuestrasARecolectar;
	}
	
}
