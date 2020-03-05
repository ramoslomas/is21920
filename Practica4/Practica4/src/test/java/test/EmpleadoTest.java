package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import modelo.Empleado;

public class EmpleadoTest {
	private Empleado empleado;
	@Test
	public void test() {
		
		assertNotNull(empleado.fechaContratacion);
		assertNotNull(empleado.baja);
		assertNotNull(empleado.categoria);
		
	}

}
