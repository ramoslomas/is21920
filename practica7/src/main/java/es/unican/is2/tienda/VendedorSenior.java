package es.unican.is2.tienda;

public class VendedorSenior extends Vendedor {//WMC 2 CCog 0

	private static final double COMISION_SENIOR = 0.01;
	
	public VendedorSenior(String nombre, String dni) {//+1 +0
		super(nombre, dni);
	}
	
	@Override
	public void anhade(double importe) {//+1 +0
		generado += importe*COMISION_SENIOR;
		t += importe;
	}
}

