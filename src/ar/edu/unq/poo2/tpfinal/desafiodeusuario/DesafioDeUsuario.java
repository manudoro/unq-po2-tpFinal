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
	public float porcentajeDeCompletitud;
	
	public DesafioDeUsuario(Desafio desafio) {
		setEstadoDeDesafio(new EstadoAceptado());
		this.desafio = desafio ;
		this.cantidadDeMuestrasPorRecolectar = desafio.getCantidadDeMuestrasARecolectar();
		this.porcentajeDeCompletitud = 0;
	}
	
	
	public int getCantidadDeMuestrasPorRecolectar() {
		return cantidadDeMuestrasPorRecolectar;
	}
	
	public float getPorcentajeDeCompletitud() {
		return porcentajeDeCompletitud;
	}


	public void reducirMuestrasPorRecolectar() {
		this.cantidadDeMuestrasPorRecolectar = estadoDeDesafio.reducirMuestrasPorRecolectar();
		
	}

	public void setEstadoDeDesafio(IEstadoDeDesafio estadoDeDesafio) {
		this.estadoDeDesafio = estadoDeDesafio;
		this.estadoDeDesafio.setDesafioDeUsuario(this);
	}


	public void recibirMuestra(Muestra muestra) {
		if (this.estaEnElAreaDelDesafio(muestra) && this.esTaDentroDeLaFechaDelDesafio(muestra)) {
			this.reducirMuestrasPorRecolectar();
			this.calucularPorcentajeDeCompletitud();
		}
	}


	private void calucularPorcentajeDeCompletitud() {
		this.porcentajeDeCompletitud = 
				(desafio.getCantidadDeMuestrasARecolectar()-(this.cantidadDeMuestrasPorRecolectar))/ desafio.getCantidadDeMuestrasARecolectar() * 100;
		
	}


	protected boolean estaEnElAreaDelDesafio(Muestra muestra) {
		/* Chekea que la muestra este dentro del area del desafio del DesafioDeUsuario */
		return this.desafio.estaEnElArea(muestra);
	}


	public boolean esTaDentroDeLaFechaDelDesafio(Muestra muestra) {
		
		return this.desafio.getRestriccionTemporal().validar(muestra.getFechaDeRecoleccion());
	}
	
	
	
	
};
