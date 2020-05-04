package es.unican.is2.tienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.tienda.VendedorEnPracticas;


public class VendedorEnPlantillaTest {
	
	private static VendedorJunior sutJunior;
	private static VendedorSenior sutSenior;

	
	@Before
	public void setUp(){
		sutJunior = new VendedorJunior("Ana", "1");
		sutSenior = new VendedorSenior("Pepe", "2");
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
		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 300, 0);
		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setT(2000);
		assertEquals(sutJunior.getTotalVentas(), 2000, 0);	
		sutJunior.setT(4000);
		assertEquals(sutJunior.getTotalVentas(), 4000, 0);	
		sutJunior.setT(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);
		
		sutSenior.setT(4500);
		assertEquals(sutSenior.getTotalVentas(), 4500, 0);		
		sutSenior.setT(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);
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
