package ar.edu.unq.poo2.tpfinal.desafio;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.poo2.tpfinal.muestra.Coordenada;
import ar.edu.unq.poo2.tpfinal.muestra.Muestra;


class AreaTest {

	
	private Area area;
	private Muestra muestra , muestra2;
	private Coordenada cordenada,cordenada1;
	private LocalDate fecha;
	@BeforeEach
	void setUp() throws Exception {
		cordenada1 = new Coordenada(2,4);
		cordenada = new Coordenada(10,5);
		fecha = LocalDate.of(2018, 10, 30);
		muestra= new Muestra( cordenada , fecha);
		muestra2= new Muestra( cordenada1 , fecha);
		area = new Area(cordenada, 5);
		
	
	}

	@Test
	void testCuandoUnaMuestra_NoEstaDentroDeUnArea() {
		assertFalse(area.estaDentro(muestra2));
	}

	@Test
	void testCuandoUnaMuestra_EstaDentroDeUnArea() {
		assertTrue(area.estaDentro(muestra));
	}
	
	
	
	
}
