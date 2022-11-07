package ar.edu.unq.poo2.tpfinal.usuario;

public enum Gusto {
	EXELENTE(5),
	MUY_BUENO(4),
	BUENO(3),
	FEO(2),
	MUY_FEO(1),
	HORRIBLE(0);


	private int valorDeCalificacion;
	
	Gusto(int valorDeCalificacion) {
		this.valorDeCalificacion = valorDeCalificacion;
	}	
	
	public int getValorDeCalificacion() {
		// Obtenemos la calificacion
		return valorDeCalificacion;
	}

}
