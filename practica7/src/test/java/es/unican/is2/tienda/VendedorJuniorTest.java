package es.unican.is2.tienda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendedorJuniorTest {

	private static VendedorJunior sutJunior;

	@Before
	public void setUp(){
		sutJunior = new VendedorJunior("Ana", "1");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutJunior.getId(), "1");
		assertEquals(sutJunior.getNombre(), "Ana");
	}

	@Test
	public void testAnhadeVenta() {		
		sutJunior.anhade(200);
		assertEquals(sutJunior.getTotalVentas(), 200, 0);
		
		sutJunior.anhade(300);
		assertEquals(sutJunior.getTotalVentas(), 500, 0);		
	}
	
	@Test
	public void testSetTotalVentas() {		
		sutJunior.setT(2000);
		assertEquals(sutJunior.getTotalVentas(), 2000, 0);	
		sutJunior.setT(4000);
		assertEquals(sutJunior.getTotalVentas(), 4000, 0);	
		sutJunior.setT(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);	
	}
	
	@Test
	public void testEquals() {
		VendedorJunior igualJunior = new VendedorJunior("Ana", "1");
		VendedorJunior distintoIdJunior = new VendedorJunior("Ana", "2");
		VendedorJunior distintoNombreJunior = new VendedorJunior("Pepe", "1");
		VendedorJunior distintoJunior = new VendedorJunior("Pepe", "6");
		
		assertTrue(sutJunior.equals(igualJunior));
		assertFalse(sutJunior.equals(distintoIdJunior));
		assertFalse(sutJunior.equals(distintoNombreJunior));
		assertFalse(sutJunior.equals(distintoJunior));	
	}
	

}
