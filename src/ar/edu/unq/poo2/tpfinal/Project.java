package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project {
	private String name;
	private String description;
	private List<User> users;
	private Set<String>categories;
	private List<Sample> samples;
	private List<Challange> challanges;
	



	public Project(String name, String description) {
		
		this.name = name;
		this.description = description;
		this.users = new ArrayList<User>();
		this.categories = new HashSet<String>();
		this.samples = new ArrayList<Sample>();
		this.challanges = new ArrayList<Challange>();
		
	}


	public List<User> getUsuarios() {
		return users;
	}

	public List<String> getCategories() {
		return new ArrayList(categories);
	}
	
	public List<Sample> getSamples() {
		return samples;
	}
	public List<Challange> getChallanges() {
		return challanges;
	}



	public void addCategory(String categoria) {
		this.categories.add(categoria);
	}
	
	public void addUser(User user) {
		this.getUsuarios().add(user);
	}
	
	public void removeUser(User user) {
		this.getUsuarios().remove(user);
	}
	
	public void addChallange(Challange challange) {
		this.getChallanges().add(challange);
	}
	
	public void addSamples(Sample sample) {
		this.getSamples().add(sample);
	}


	public String getName() {
		return name;
	}
	
	
	
	
	
	
	
	
}
