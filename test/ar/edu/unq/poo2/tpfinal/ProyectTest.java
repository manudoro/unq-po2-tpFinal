package ar.edu.unq.poo2.tpfinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectTest {

	Project proyect;
	User user , user1;
	Sample sample;
	Challange challange;
	Category category;
	
	@BeforeEach
	void setUp() throws Exception {
		
		proyect = new Project("AquatiWord", "Cs.Natural");
		user = mock(User.class);
		category = mock(Category.class);
	}

	@Test
	void testTheProyectAddUser() {
		proyect.addUser(user);
		assertEquals(proyect.getUsuarios().size() , 1);	
	}

	@Test 
	void testTheProyectDelateUser(){
		proyect.addUser(user);
		proyect.removeUser(user);
		assertEquals(proyect.getUsuarios().size(), 0);
	}
	
	@Test
	
	void testTheProyectAddCategory() {
		proyect.addCategory(category);
		assertEquals(proyect.getCategories().size() , 1);	
		
	}
	
	
}
