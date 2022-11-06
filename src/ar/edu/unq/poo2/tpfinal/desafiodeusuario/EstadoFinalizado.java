package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public class EstadoFinalizado implements IEstadoDeDesafio {

	private DesafioDeUsuario desafioDeUsuario;

	@Override
	public void reducirMuestrasPorRecolectar() {
	}

	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;

	}

	@Override
	public void recibirMuestra(Muestra muestra) {
		// un desafio finalizado no puede recibir muestras
		
	}

}
