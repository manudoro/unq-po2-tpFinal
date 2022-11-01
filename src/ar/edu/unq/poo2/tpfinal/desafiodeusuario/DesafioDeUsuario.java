package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.usuario.Gusto;

public class DesafioDeUsuario{

	/* Esta clase modela el progreso de un desafio para un usuario concreto */
	
	private Desafio desafio;
	private IEstadoDeDesafio estadoDeDesafio ;
	private Gusto gustoDeUsuario;
	private int cantidadDeMuestrasPorRecolectar;
	
	public DesafioDeUsuario(Desafio desafio) {
		setEstadoDeDesafio(new EstadoAceptado());
		this.desafio = desafio ;
		this.cantidadDeMuestrasPorRecolectar = desafio.getCantidadDeMuestrasARecolectar();
	}
	
	
	public int getCantidadDeMuestrasPorRecolectar() {
		return cantidadDeMuestrasPorRecolectar;
	}

	public void reducirMuestrasPorRecolectar() {
		this.cantidadDeMuestrasPorRecolectar = estadoDeDesafio.reducirMuestrasPorRecolectar();
	}

	public void setEstadoDeDesafio(IEstadoDeDesafio estadoDeDesafio) {
		this.estadoDeDesafio = estadoDeDesafio;
		this.estadoDeDesafio.setDesafioDeUsuario(this);
	}
}
