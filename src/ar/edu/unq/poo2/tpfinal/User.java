package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String id;
	private List<Sample> samples;
	private List<Challange> challanges;
	
	public User(String name, String id) {
		this.name = name;
		this.id = id;
		this.samples = new ArrayList<Sample>();
		this.challanges = new ArrayList<Challange>();
	}

	public List<Sample> getSamples() {
		return samples;
	}


	public List<Challange> getChallanges() {
		return challanges;
	}


	public void subscribeProyect(Project proyect) {
		proyect.addUser(this);
	}
	
	public void unsubscribe(Project proyect) {
		proyect.removeUser(this);
	}
	
}

