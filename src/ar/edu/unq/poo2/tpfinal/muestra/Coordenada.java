package ar.edu.unq.poo2.tpfinal.muestra;

public class Coordenada {
	

 /*Se crearon las clases latitud y longitud para realizar polimorfismo*/

	private int latitud;
	private int longitud;
		
	public Coordenada(int x, int y) { // CONSTRUCTOR REPETIDO. ¿SOBRECARGA DE CONSTRUCTORES?
		super();
		this.latitud = x;
		this.longitud = y;
	}

	public int getLatitud() {
		return latitud;
	}

	public int getLongitud() {
		return longitud;
	}
	public boolean estaDentroConRespectoAlRadio(Coordenada coordenada, int radio) {
		int latitud = coordenada.getLatitud();
		int longitud = coordenada.getLongitud();
		
		return esParteDelArea(this.latitud, latitud, radio) && esParteDelArea(this.longitud, longitud, radio);
	}
	
	/* La longitud y la latitud son distancias angulares */
	public boolean esParteDelArea(int unaDistanciaAngular, int otraDistanciaAngular, int radio) {
		
		return Math.abs(unaDistanciaAngular - otraDistanciaAngular) <= radio;
	}
}

