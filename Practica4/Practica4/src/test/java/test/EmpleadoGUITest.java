package test;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GUI.EmpleadosGUI;

public class EmpleadoGUITest {
	
	private FrameFixture demo;
	
	@Before
	public void setUp() {
		EmpleadosGUI gui = new EmpleadosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnCalcular").requireText("CALCULAR");
		
		//Prueba de directivo de baja con antigüedad >20 años
		demo.textBox("txtFechaContratacion").setText("11-04-1999");
		demo.radioButton("btnBaja").check();
		demo.comboBox().selectItem("DIRECTIVO");
		//Pulsamos el botón
		demo.button("btnCalcular").click();		
		//Comprobamos la salida
		demo.textBox("txtSueldo").requireText("1325.0");
		
		//Prueba de directivo de baja con antigüedad >20 años
		demo.textBox("txtFechaContratacion").setText("11-04-2009");
		demo.radioButton("btnBaja").uncheck();
		demo.comboBox().selectItem("GESTOR");
		// Pulsamos el botón
		demo.button("btnCalcular").click();		
		// Comprobamos la salida
		demo.textBox("txtSueldo").requireText("1300.0");
			
		//  Prueba de directivo de baja con antigüedad >20 años
		demo.textBox("txtFechaContratacion").setText("11-04-2014");
		demo.radioButton("btnBaja").check();
		demo.comboBox().selectItem("OBRERO");
		// Pulsamos el botón
		demo.button("btnCalcular").click();		
		// Comprobamos la salida
		demo.textBox("txtSueldo").requireText("800.0");
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
