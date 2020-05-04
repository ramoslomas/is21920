package original;


public class VendedorEnPlantilla extends Vendedor {//WMC 2 CCog 0
	
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String dni, TipoVendedor tipo) {//+1
		super(nombre, dni);
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() {//+1
		return tipo;
	}
}
