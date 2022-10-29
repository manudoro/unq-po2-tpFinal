package ar.edu.unq.poo2.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	Project proyect;
	User user1, user2;
	Sample sample;
	Challange chanalnge;
	
	@BeforeEach	
	void setUp() throws Exception {
	user1 = new User("2124", "Jisus");
	user2=  new User("2122", "Kamus");
	proyect = new Project("Programmin", "Cs.Tecnologhy");
	sample = mock(Sample.class);
	}

	@Test
	void testTheUsersubscribesToProyect() {
	
		user1.subscribeProyect(proyect);
		user2.subscribeProyect(proyect);
		assertEquals(proyect.getUsuarios().size() , 2);
	}

	@Test
	
	void testTheUserUnSubscribresToProyect() {
		user1.subscribeProyect(proyect);
		user1.unsubscribe(proyect);
		assertEquals(proyect.getUsuarios().size(),0);
	}
}
