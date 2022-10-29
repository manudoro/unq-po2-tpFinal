package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private List<User> users;
	private List<Category> categories;
	private List<Sample> samples;
	private List<Challange> challanges;
	



	public Project(String name, String description) {
		
		this.name = name;
		this.description = description;
		this.users = new ArrayList<User>();
		this.categories = new ArrayList<Category>();
		this.samples = new ArrayList<Sample>();
		this.challanges = new ArrayList<Challange>();
		
	}


	public List<User> getUsuarios() {
		return users;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public List<Sample> getSamples() {
		return samples;
	}
	public List<Challange> getChallanges() {
		return challanges;
	}



	public void addCategory(Category category) {
		this.getCategories().add(category);
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
