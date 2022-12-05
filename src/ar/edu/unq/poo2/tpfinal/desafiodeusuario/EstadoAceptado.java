package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class EstadoAceptado implements IEstadoDeDesafio {
	
	
	private DesafioDeUsuario desafioDeUsuario;
	private EstadoFinalizado estadoFinalizado;
	
	

	public EstadoAceptado() {
		estadoFinalizado = new EstadoFinalizado();
	}



	
	private void reducirMuestrasPorRecolectar() {
		desafioDeUsuario.reducirCantidadDeMuestras();
		if (!desafioDeUsuario.hayMuestrasPorRecolectar()) {
			this.desafioDeUsuario.setEstadoDeDesafio(estadoFinalizado);
			this.desafioDeUsuario.getUsuario().agregarDesafiosCompletos(this.desafioDeUsuario);
		}
	
	}

	@Override
	public float calcularPorcentajeDeCompletitud(Desafio desafio) {
		return (desafio.getCantidadDeMuestrasARecolectar()-desafioDeUsuario.getCantidadDeMuestrasPorRecolectar()) * 100 / desafio.getCantidadDeMuestrasARecolectar() ;

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

	}
}
