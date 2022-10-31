package ar.edu.unq.poo2.tpfinal.muestra;

public class Coordenada {
	
		
	
	private int x;
	private int y;
		
	public Coordenada() { // CONSTRUCTOR REPETIDO
		this.x = 0;
		this.y = 0;
	}
	public Coordenada(int x, int y) { // CONSTRUCTOR REPETIDO. ¿SOBRECARGA DE CONSTRUCTORES?
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
		
		
		
}

