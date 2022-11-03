package ar.edu.unq.poo2.tpfinal.desafiodeusuario;


import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
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


	public void recibirMuestra(Muestra muestra) {
		if (this.estaEnElAreaDelDesafio(muestra)) {
			this.reducirMuestrasPorRecolectar();
		}
	}


	protected boolean estaEnElAreaDelDesafio(Muestra muestra) {
		/* Chekea que la muestra este dentro del area del desafio del DesafioDeUsuario */
		
		return this.desafio.estaEnElArea(muestra);
	}

	public boolean estaDentroDeLaFechaPermitida(Muestra muestra) {
		return true;
	}


	public Desafio getDesafio() {
		// TODO Auto-generated method stub
		return this.desafio;
	}
		
		
};
