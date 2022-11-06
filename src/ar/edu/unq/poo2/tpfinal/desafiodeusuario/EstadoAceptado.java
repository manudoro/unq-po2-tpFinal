package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class EstadoAceptado implements IEstadoDeDesafio {
	
	
	private DesafioDeUsuario desafioDeUsuario;
	private EstadoFinalizado estadoFinalizado;
	
	

	public EstadoAceptado() {
		estadoFinalizado = new EstadoFinalizado();
	}



	@Override
	public int reducirMuestrasPorRecolectar() {
		
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		cantidadDeMuestras = cantidadDeMuestras - 1;
		
		if (cantidadDeMuestras == 0) {
			this.desafioDeUsuario.setEstadoDeDesafio(estadoFinalizado);
		}
		return cantidadDeMuestras;
	
	}
	
	
	
	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
	}



	@Override
	public void recibirMuestra(Muestra muestra) {
		if (this.desafioDeUsuario.estaEnElAreaDelDesafio(muestra) && this.desafioDeUsuario.esTaDentroDeLaFechaDelDesafio(muestra)) {
			this.desafioDeUsuario.reducirMuestrasPorRecolectar();
			this.desafioDeUsuario.calucularPorcentajeDeCompletitud();
		}
		if (!desafioDeUsuario.restriccionEstaAbierta(muestra)) {
			this.desafioDeUsuario.setEstadoDeDesafio(estadoFinalizado);
		}
		
		
		
	}
}
