package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

public class EstadoAceptado implements IEstadoDeDesafio {
	
	
	private DesafioDeUsuario desafioDeUsuario;

	
	
	
	
	@Override
	public int reducirMuestrasPorRecolectar() {
		
		
		int cantidadDeMuestras = this.desafioDeUsuario.getCantidadDeMuestrasPorRecolectar();
		cantidadDeMuestras = cantidadDeMuestras - 1;
		
		if (cantidadDeMuestras == 0) {
			IEstadoDeDesafio estadoDeDesafio = new EstadoFinalizado();
			this.desafioDeUsuario.setEstadoDeDesafio(estadoDeDesafio);
		}
		
		return cantidadDeMuestras;
	}
	
	@Override
	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
	}
}
