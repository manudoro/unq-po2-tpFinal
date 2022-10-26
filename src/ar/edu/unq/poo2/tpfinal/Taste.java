package ar.edu.unq.poo2.tpfinal;

public enum Taste {
	LOVE_IT(5),
	LIKE_A_LOT(4),
	LIKE(3),
	DONT_LIKE(2),
	DONT_LIKE_ALL(1),
	HORRIBLE(0);


	private int value;
	
	Taste(int i) {
		this.value = i;
	}	
	
	public int getValue() {
		return value;
	}

}
