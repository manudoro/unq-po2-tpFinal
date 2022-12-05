package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class EstadoFinalizado implements IEstadoDeDesafio {

	private DesafioDeUsuario desafioDeUsuario;


	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;

	}

	@Override
	public void recibirMuestra(Muestra muestra) {
		// un desafio finalizado no puede recibir muestras
		
	}
	@Override 
	public float calcularPorcentajeDeCompletitud(Desafio desafio) {
		return 100;
	}

}
