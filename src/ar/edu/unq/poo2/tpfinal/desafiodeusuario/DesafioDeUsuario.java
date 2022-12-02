package ar.edu.unq.poo2.tpfinal.desafiodeusuario;



import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;
import ar.edu.unq.poo2.tpfinal.usuario.Valoracion;
import ar.edu.unq.poo2.tpfinal.usuario.Usuario;

public class DesafioDeUsuario{

	/* Esta clase modela el progreso de un desafio para un usuario concreto */
	
	private Desafio desafio;
	private IEstadoDeDesafio estadoDeDesafio ;
	private Valoracion gustoDeUsuario;
	private int cantidadDeMuestrasPorRecolectar;
	private float porcentajeDeCompletitud;
	private Usuario usuario; 
	
	public DesafioDeUsuario(Desafio desafio , Usuario usuario) {
		setEstadoDeDesafio(new EstadoAceptado());
		this.desafio = desafio ;
		this.cantidadDeMuestrasPorRecolectar = desafio.getCantidadDeMuestrasARecolectar();
		this.porcentajeDeCompletitud = 0;
		this.usuario = usuario;
		this.gustoDeUsuario = Valoracion.HORRIBLE; // Se considera horrible como caso neutro
	}
	
	
	public void setGustoDeUsuario(Valoracion gustoDeUsuario) {
		this.gustoDeUsuario = gustoDeUsuario;
	}

	public Desafio getDesafio1() {
		return desafio;
	}

	public Valoracion getGustoDeUsuario() {
		return gustoDeUsuario;
	}
	
	public int getValorGustoDeUsuario() {
		return gustoDeUsuario.getValorDeCalificacion();
	}
	
	public int getCantidadDeMuestrasPorRecolectar() {
		return cantidadDeMuestrasPorRecolectar;
	}
	
	public float getPorcentajeDeCompletitud() {
		calucularPorcentajeDeCompletitud();
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

	protected boolean esValidaParaDesafio(Muestra muestra) {
		/* Chekea que la muestra este dentro del area del desafio del DesafioDeUsuario */
		return this.desafio.correspondeA(muestra);
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


	public void validarMuestra(Muestra muestra) {
		this.usuario.enviarMuestraAProyectos(muestra);
		
	}


	public Desafio getDesafio() {
		return desafio;
	}

	
};
