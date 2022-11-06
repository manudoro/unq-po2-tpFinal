package ar.edu.unq.poo2.tpfinal.desafio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RestriccionMixta implements IRestriccionTemporal {

	private List<IRestriccionTemporal> restricciones;
	
	
	
	
	public RestriccionMixta() {
	
		this.restricciones = new ArrayList<IRestriccionTemporal>();
	}


	public List<IRestriccionTemporal> getRestricciones() {
		return restricciones;
	}

	
	
	
	public void agregarRestriccionTemporal(IRestriccionTemporal restriccionTemporal) {
		this.restricciones.add(restriccionTemporal);
	}
	
	public void removerRestriccionTemporal(IRestriccionTemporal restriccionTemporal) {
		this.restricciones.remove(restriccionTemporal);
	}
	

	
	@Override
	public boolean validar(LocalDate fecha) {
		//
		return this.restricciones.stream().allMatch(f -> f.validar(fecha));
	}


	@Override
	public boolean estaAbierta(LocalDate fecha) {
		
		return this.restricciones.stream().filter(r -> !r.validar(fecha)).toList().stream().allMatch(r -> r.estaAbierta(fecha));
	}

	
	
	
	

}
