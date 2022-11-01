package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

public class EstadoFinalizado implements IEstadoDeDesafio {

	private DesafioDeUsuario desafioDeUsuario;

	@Override
	public int reducirMuestrasPorRecolectar() {
		return 0;
	}

	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;

	}

}
