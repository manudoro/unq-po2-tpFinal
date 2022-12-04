package ar.edu.unq.poo2.tpfinal.desafiodeusuario;

import ar.edu.unq.poo2.tpfinal.desafio.Desafio;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;

public interface IEstadoDeDesafio {

	public void setDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario);
	public void recibirMuestra(Muestra muestra);
	public float calcularPorcentajeDeCompletitud(Desafio desafio);
}
