package ar.edu.unq.poo2.tpfinal.muestra;

public class Coordenada {
	

 /*Se crearon las clases latitud y longitud para realizar polimorfismo*/

	private Distancia latitud;
	private Distancia longitud;
		
	public Coordenada() { // CONSTRUCTOR REPETIDO
		this.latitud = new Distancia(0);
		this.longitud = new Distancia(0);
	}
	public Coordenada(int x, int y) { // CONSTRUCTOR REPETIDO. ¿SOBRECARGA DE CONSTRUCTORES?
		super();
		this.latitud = new Distancia(x);
		this.longitud = new Distancia(y);
	}

	public Distancia getLatitud() {
		return latitud;
	}

	public Distancia getLongitud() {
		return longitud;
	}
	public boolean estaDentroConRespectoAlRadio(Coordenada coordenada, int radio) {
		Distancia latitud = coordenada.getLatitud();
		Distancia longitud = coordenada.getLongitud();
		
		return this.latitud.esParteDelArea(latitud, radio) && this.longitud.esParteDelArea(longitud, radio);
	}
	
	
		
		
		
}

