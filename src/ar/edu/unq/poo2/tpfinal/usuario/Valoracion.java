package ar.edu.unq.poo2.tpfinal.usuario;

public enum Valoracion {
	EXELENTE(6),
	MUY_BUENO(5),
	BUENO(4),
	FEO(3),
	MUY_FEO(2),
	HORRIBLE(1),
	NEUTRO(0);


	private int valorDeCalificacion;
	
	Valoracion(int valorDeCalificacion) {
		this.valorDeCalificacion = valorDeCalificacion;
	}	
	
	public int getValorDeCalificacion() {
		// Obtenemos la calificacion
		return valorDeCalificacion;
	}

}
