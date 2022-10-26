package ar.edu.unq.poo2.tpfinal;

public enum Difficulty {
	
	
	VERY_EASY(1),
	EASY(2),
	MEDIUM(3),
	HARD(4),
	VERY_HARD(5);

	private int value;
	
	Difficulty(int i) {
	
		this.value = i;
		
	}

	public int getValue() {
		return value;
	}

	
	
}
