package es.unican.is2.tienda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendedorSeniorTest {

	private static VendedorSenior sutSenior;
	
	@Before
	public void setUp(){
		sutSenior = new VendedorSenior("Pepe", "2");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutSenior.getId(), "2");
		assertEquals(sutSenior.getNombre(), "Pepe");
	}

	@Test
	public void testAnhadeVenta() {		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 300, 0);
		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
	}
	
	@Test
	public void testSetTotalVentas() {				
		sutSenior.setT(4500);
		assertEquals(sutSenior.getTotalVentas(), 4500, 0);		
		sutSenior.setT(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);
		sutSenior.setT(0);
		assertEquals(sutSenior.getTotalVentas(), 0, 0);		
	}
	
	@Test
	public void testEquals() {			
		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3");
		VendedorSenior distintoNombreSenior = new VendedorSenior("Ana", "2");
		VendedorSenior distintoSenior = new VendedorSenior("Juan", "6");
		
		assertTrue(sutSenior.equals(igualSenior));
		assertFalse(sutSenior.equals(distintoIdSenior));
		assertFalse(sutSenior.equals(distintoNombreSenior));
		assertFalse(sutSenior.equals(distintoSenior));		
	}
}
