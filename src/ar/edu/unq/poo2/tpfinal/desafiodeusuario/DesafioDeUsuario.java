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
	
	public DesafioDeUsuario(Desafio desafio) {
		setEstadoDeDesafio(new EstadoAceptado());
		this.desafio = desafio ;
		this.cantidadDeMuestrasPorRecolectar = desafio.getCantidadDeMuestrasARecolectar();
	}
	
	
	public int getCantidadDeMuestrasPorRecolectar() {
		return cantidadDeMuestrasPorRecolectar;
	}

	public void reducirMuestrasPorRecolectar() {
		this.cantidadDeMuestrasPorRecolectar = estadoDeDesafio.reducirMuestrasPorRecolectar();
	}

	public void setEstadoDeDesafio(IEstadoDeDesafio estadoDeDesafio) {
		this.estadoDeDesafio = estadoDeDesafio;
		this.estadoDeDesafio.setDesafioDeUsuario(this);
	}


	public void recibirMuestra(Muestra muestra) {
		if (this.estaEnElArea(muestra)) {
			this.reducirMuestrasPorRecolectar();
		}
	}


	private boolean estaEnElArea(Muestra muestra) {
		/* Chekea que la muestra este dentro del area del desafio del DesafioDeUsuario */
		
		int resultadoLatitud = Math.abs(resultadoLatitudDeDesafioConMuestra(muestra));
		int resultadoLongitud = Math.abs(resultadoDeLongitudDeDesafioConMuestra(muestra));
		
		return estanLasDistanciasDentroDelArea(resultadoLatitud, resultadoLongitud);
	}


	// SE PUEDEN MEJORAR
	
	private boolean estanLasDistanciasDentroDelArea(int resultadoLatitud, int resultadoLongitud) {
		return estaLaDistanciaDentroDelArea(resultadoLongitud) && estaLaDistanciaDentroDelArea(resultadoLatitud);
	}


	private boolean estaLaDistanciaDentroDelArea(int resultadoDistancia) {
		return this.desafio.distanciaDentroDelArea(resultadoDistancia);
	}


	
	private int resultadoDeLongitudDeDesafioConMuestra(Muestra muestra) {
		return this.desafio.relacionDeLongitudDeDesafioYMuestra(muestra);
	}


	private int resultadoLatitudDeDesafioConMuestra(Muestra muestra) {
		return this.desafio.relacionDeLatitudDeDesafioYMuestra(muestra);
	}
		
		
};
