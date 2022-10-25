package ar.edu.unq.poo2.tpfinal;

import java.util.List;

public class User {
	private String name;
	private String id;
	private List<Sample> samples;
	private List<Challange> challanges;
	
	public User(String name, String id, List<Sample> samples, List<Challange> challanges) {
		this.name = name;
		this.id = id;
		this.samples = samples;
		this.challanges = challanges;
	}

	public List<Sample> getSamples() {
		return samples;
	}


	public List<Challange> getChallanges() {
		return challanges;
	}


	public void subscribeProyect(Proyect proyect) {
		proyect.addUser(this);
	}
	
	public void unsubscribe(Proyect proyect) {
		proyect.removeUser(this);
	}
	
}

