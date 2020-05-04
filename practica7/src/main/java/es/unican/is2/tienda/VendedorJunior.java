package es.unican.is2.tienda;

public class VendedorJunior extends Vendedor {//WMC 2 CCog 0

	private static final double COMISION_JUNIOR = 0.005;
	
	
	public VendedorJunior(String nombre, String dni) {//+1 +0
		super(nombre, dni);
	}
	
	@Override
	public void anhade(double importe) {//+1 +0
		generado += importe*COMISION_JUNIOR;
		t += importe;
	}
}
