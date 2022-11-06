package ar.edu.unq.poo2.tpfinal.desafiodeusuario;


import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Gusto;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class DesafioDeUsuario{

	/* Esta clase modela el progreso de un desafio para un usuario concreto */
	
	private Desafio desafio;
	private IEstadoDeDesafio estadoDeDesafio ;
	private Gusto gustoDeUsuario;
	private int cantidadDeMuestrasPorRecolectar;
	private float porcentajeDeCompletitud;
	private Usuario usuario; 
	
	public DesafioDeUsuario(Desafio desafio , Usuario usuario) {
		setEstadoDeDesafio(new EstadoAceptado());
		this.desafio = desafio ;
		this.cantidadDeMuestrasPorRecolectar = desafio.getCantidadDeMuestrasARecolectar();
		this.porcentajeDeCompletitud = 0;
		this.usuario = usuario;
	}
	
	
	public int getCantidadDeMuestrasPorRecolectar() {
		return cantidadDeMuestrasPorRecolectar;
	}
	
	public float getPorcentajeDeCompletitud() {
		return porcentajeDeCompletitud;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	public IEstadoDeDesafio getEstadoDeDesafio() {
		return estadoDeDesafio;
	}

	public void setEstadoDeDesafio(IEstadoDeDesafio estadoDeDesafio) {
		this.estadoDeDesafio = estadoDeDesafio;
		this.estadoDeDesafio.setDesafioDeUsuario(this);
	}


	public void recibirMuestra(Muestra muestra) {
		this.estadoDeDesafio.recibirMuestra(muestra);
	}


	 boolean restriccionEstaAbierta(Muestra muestra) {
		
		return this.desafio.getRestriccionTemporal().estaAbierta(muestra.getFechaDeRecoleccion()) ;
	}


	public void calucularPorcentajeDeCompletitud() {
		this.porcentajeDeCompletitud = 
				(desafio.getCantidadDeMuestrasARecolectar()-this.cantidadDeMuestrasPorRecolectar) * 100 / desafio.getCantidadDeMuestrasARecolectar() ;
				
	}

	protected boolean estaEnElAreaDelDesafio(Muestra muestra) {
		/* Chekea que la muestra este dentro del area del desafio del DesafioDeUsuario */
		return this.desafio.estaEnElArea(muestra);
	}

	public boolean esTaDentroDeLaFechaDelDesafio(Muestra muestra) {
		
		return this.desafio.getRestriccionTemporal().validar(muestra.getFechaDeRecoleccion());
	}


	public void setMuestrasPorRecolectar(int cantidadDeMuestras) {
		this.cantidadDeMuestrasPorRecolectar = cantidadDeMuestras; 
		
	}
	
	public void agregarDesafioCompletoAListaDedesafiosCompletos(DesafioDeUsuario desafioDeUsuario) {
		this.usuario.agregarDesafiosCompletos(desafioDeUsuario);
	}



	public boolean contieneAlDesafio(Desafio desafio) {
		
		return this.desafio == desafio;
	}

	
};
