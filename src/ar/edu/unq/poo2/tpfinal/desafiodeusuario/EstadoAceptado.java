package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class EstadoAceptado implements IEstadoDeDesafio {
	
	
	private DesafioDeUsuario desafioDeUsuario;
	private EstadoFinalizado estadoFinalizado;
	
	

	public EstadoAceptado() {
		estadoFinalizado = new EstadoFinalizado();
	}



	
	private void reducirMuestrasPorRecolectar() {
		
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		cantidadDeMuestras = cantidadDeMuestras - 1;
		
		if (cantidadDeMuestras == 0) {
			this.desafioDeUsuario.setEstadoDeDesafio(estadoFinalizado);
			this.desafioDeUsuario.getUsuario().agregarDesafiosCompletos(this.desafioDeUsuario);
		}
		this.desafioDeUsuario.setMuestrasPorRecolectar(cantidadDeMuestras);
	
	}
	
	
	
	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
	}



	@Override
	public void recibirMuestra(Muestra muestra) {
		if (this.desafioDeUsuario.esValidaParaDesafio(muestra)) {
			this.reducirMuestrasPorRecolectar();
			this.desafioDeUsuario.validarMuestra(muestra);
		}
		if (!desafioDeUsuario.restriccionEstaAbierta(muestra)) {
			this.desafioDeUsuario.setEstadoDeDesafio(estadoFinalizado);
		}
		
		
		
	}
}
