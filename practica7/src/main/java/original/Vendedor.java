package original;


/**
 * Vendedor de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
public abstract class Vendedor {//WMC 10 CCog 2
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	public Vendedor(String nombre, String id) {//+1 +0
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {//+1 +0
		return nombre; 
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {//+1 +0
		return id;
	}

	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {//+1 +0
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {//+1 +0
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){//+1 +0
		t += importe;
	}
	
	
	@Override
	public boolean equals(Object obj) {//+4 +2
		if (!(obj instanceof Vendedor)) //+1 +1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.id.equals(id) && v.nombre.equals(nombre));//+2 +1
	}
	
	
}
