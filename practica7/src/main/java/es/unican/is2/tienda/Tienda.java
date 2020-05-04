package es.unican.is2.tienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gesti�n de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como par�metro al crear la tienda
 */
public class Tienda {//WMC 29 CCog 19

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { // +1 +0
		this.datos = datos;
		lee();
	}

	/**
	 * Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 */
	public String direccion() {// +1 +0
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { // +1 +0
		return nombre;
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException { // +2 +1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) { // +1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como par�metro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ning�n vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { // +2 +1
		Vendedor v = buscaVendedor(id);
		if (v == null) { // +1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * A�ade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se a�ade la venta false si no se encuentra el vendedor
	 */	
	public boolean anhadeVenta(String id, double importe) throws IOException { // +2 +1
		Vendedor v = buscaVendedor(id);
		if (v == null) {//+1
			return false;
		}
		v.anhade(importe);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {// +3	+3
		for (Vendedor v : lista) {//+1
			if (v.getId().equals(id)) {//+1
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { // +1	+0
		return lista;
	}

	/**
	 * M�todo que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws IOException { // +5 +7
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { //+1
			if (v instanceof VendedorEnPracticas) // +1
				practicas.add(v); 
			else if (v instanceof VendedorJunior) // +1
				junior.add(v);
			else 
				senior.add(v);
		}
		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			
			out.println("    Senior");
			escribe(out, senior);
			out.println();
			
			out.println("    Junior");			
			escribe(out, junior);
			out.println();
			
			out.println("    Practicas");
			escribe(out, practicas);

		} finally {
			if (out != null) //+1
				out.close();
		}
	}
	
	private void lee() { // +2 +2
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();

			leeAux(in,TipoVendedor.SENIOR);
			
			leeAux(in,TipoVendedor.JUNIOR);
			
			leeAux(in,TipoVendedor.PRACTICAS);
		} catch (FileNotFoundException e) {
		} finally {
			if (in != null) { //+1
				in.close();
			}
		} // try
	}

	private void leeAux(Scanner in, TipoVendedor tipo) { // +7 +6
		Vendedor ven;
		String compare;
		if(tipo == TipoVendedor.SENIOR ) // +1
			compare = "Junior";
		else if(tipo == TipoVendedor.JUNIOR ) // +1
			compare = "Practicas";
		else 
			compare = "fin";
		while (in.hasNext() && !in.next().equals(compare)) { //+1

			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			switch (tipo) { // +3
			case SENIOR:
				ven = new VendedorSenior(nombre, idIn);
				break;
			case JUNIOR:
				ven = new VendedorJunior(nombre, idIn);
				break;
			default:
				ven = new VendedorEnPracticas(nombre, idIn);
				break;
			}												
			ven.setT(totalVentas);
			lista.add(ven);
		}
	}

	private void escribe(PrintWriter out, List<Vendedor> lista) {	// +2 +1
		for (Vendedor v : lista) //+1
			out.println("      Nombre: " + v.getNombre() + "   Id: " + v.getId() + "   TotalVentasMes: "
					+ v.getTotalVentas());
	}
}
