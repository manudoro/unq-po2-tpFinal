package ar.edu.unq.poo2.tpfinal.desafio;

public enum Dificultad {
	
	
	MUY_FACIL(1),
	FACIL(2),
	MEDIO(3),
	DIFICIL(4),
	MUY_DIFICIL(5);

	private int valorDeDificultad;
	
	Dificultad(int i) {
	
		this.valorDeDificultad = i;
		
	}

	public int getValorDeDificultad() {
		return valorDeDificultad;
	}

	
	
}
