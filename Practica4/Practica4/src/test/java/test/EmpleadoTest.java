package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import modelo.Empleado;
import modelo.Empleado.Categoria;
import modelo.Empleado.DatoIncorrectoException;

public class EmpleadoTest {
	private Empleado empleado;


	@Before
	public void setUp() throws Exception{
		empleado = new Empleado("Pepe",LocalDate.now(),false,Categoria.DIRECTIVO);
	}


	//----------------------------------------------------CASOS VALIDOS-----------------------------------------------------------
	@Test
	public void testSueldoBruto() {

		//intermedio entre -infinito y 20, de baja, gestor
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(40),true, Categoria.GESTOR);
			assertTrue(empleado1.sueldoBruto()==1100);
		}catch(DatoIncorrectoException e){
			
		}

		
		//limite entre -infinito y 20, trabajando, gestor
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(20),false, Categoria.GESTOR);
			assertTrue(empleado1.sueldoBruto()==1400);

		}catch(DatoIncorrectoException e){

		}



		//limite entre 20 y 10, de baja, DIRECTIVO
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(20).plusDays(1),true, Categoria.DIRECTIVO);
			assertTrue(empleado1.sueldoBruto()==1225);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}



		
		//intermedio entre 20 y 10, trabajando, OBRERO
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(15),false, Categoria.OBRERO);
			assertTrue(empleado1.sueldoBruto()==1100);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}



		
		//limite entre 20 y 10, trabajando, gestor
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(10),false, Categoria.GESTOR);
			assertTrue(empleado1.sueldoBruto()==1300);
			
		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}

		
		//limite entre 10 y 5, de baja, DIRECTIVO
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(10).plusDays(1),true, Categoria.DIRECTIVO);
			assertTrue(empleado1.sueldoBruto()==1175);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}


		//intermedio entre 10 y 5, trabajando, gestor
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(7),false, Categoria.GESTOR);
			assertTrue(empleado1.sueldoBruto()==1250);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}


		//limite entre 10 y 5, de baja, OBRERO
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(5),true, Categoria.OBRERO);
			assertTrue(empleado1.sueldoBruto()==800);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}



		//limite entre 5 y hoy, trabajando, OBRERO
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(5).plusDays(1),false, Categoria.OBRERO);
			assertTrue(empleado1.sueldoBruto()==1000);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}


		//intermedio entre 5 y hoy, de baja, DIRECTIVO
		try {		
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().minusYears(3),true, Categoria.DIRECTIVO);
			assertTrue(empleado1.sueldoBruto()==1125);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}


		//limite entre 5 y hoy, de baja, gestor
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now(),true, Categoria.GESTOR);
			assertTrue(empleado1.sueldoBruto()==900);

		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}
		
		
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now(),true, Categoria.GESTOR);
			empleado1.darDeAlta();
		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}
		
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now(),false, Categoria.GESTOR);
			empleado1.darDeBaja();
		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}
		
		
		//--------------------------------------------------------CASOS NO VALIDOS----------------------------------------------------------------
		
		//Dia posterior al actual
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now().plusDays(1),true, Categoria.GESTOR);
			empleado1.sueldoBruto();
			fail("Excepcion no lanzada");
		}catch(DatoIncorrectoException e){

		}


		//Fecha nula
		try {
			Empleado empleado1 = new Empleado("Pepe", null ,true, Categoria.GESTOR);
			empleado1.sueldoBruto();
			fail("Excepcion no lanzada");
		}catch(NullPointerException e){

		} catch (DatoIncorrectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now(),false, Categoria.GESTOR);
			empleado1.darDeAlta();
		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}
	
		try {
			Empleado empleado1 = new Empleado("Pepo", LocalDate.now(),true, Categoria.GESTOR);
			empleado1.darDeBaja();
		}catch(DatoIncorrectoException e){
			fail("No debería lanzar la excepcion");
		}
		
		
	}
	
}
