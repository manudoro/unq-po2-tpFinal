package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class System {
	
	private IRecomendationForm recomendation;
	private User user;
	private List<Challange> challangesRecommeded;
	
	
	public System(IRecomendationForm recomendation, User user) {
	
		this.recomendation = recomendation;
		this.user = user;
		this.challangesRecommeded = new ArrayList<Challange>();
	}
	
	
	
	
	
	
}
