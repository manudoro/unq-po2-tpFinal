package ar.edu.unq.poo2.tpfinal.muestra;

public class Coordenada {
	
		
	
	private Integer x;
	private Integer y;
		
	public Coordenada() { // CONSTRUCTOR REPETIDO
		this.x = 0;
		this.y = 0;
	}

	public Integer getX() {
		return x;
	}


	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Coordenada(Integer x, Integer y) { // CONSTRUCTOR REPETIDO. ¿SOBRECARGA DE CONSTRUCTORES?
		super();
		this.x = x;
		this.y = y;
	}
		
		
		
}

