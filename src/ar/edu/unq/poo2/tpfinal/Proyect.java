package ar.edu.unq.poo2.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Proyect {
	private String name;
	private String description;
	private List<User> users;
	private List<Category> categorys;
	private List<Sample> samples;
	private List<Challange> challanges;
	



	public Proyect(String name, String description) {
		
		this.name = name;
		this.description = description;
		this.users = new ArrayList<User>();
		this.categorys = new ArrayList<Category>();
		this.samples = new ArrayList<Sample>();
		this.challanges = new ArrayList<Challange>();
		
	}


	public List<User> getUsuarios() {
		return users;
	}

	public List<Category> getCategorys() {
		return categorys;
	}
	
	public List<Sample> getSamples() {
		return samples;
	}
	public List<Challange> getChallanges() {
		return challanges;
	}



	public void addCategory(Category category) {
		this.getCategorys().add(category);
	}
	
	public void addUser(User user) {
		this.getUsuarios().add(user);
	}
	
	public void removeUser(User user) {
		this.getUsuarios().remove(user);
	}
	
	
	
	
	
	
}
