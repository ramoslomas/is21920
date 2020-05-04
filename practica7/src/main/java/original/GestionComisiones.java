package original;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import es.unican.is2.tienda.Tienda;
import es.unican.is2.tienda.Vendedor;
import fundamentos.Menu;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Gestion de las comisiones de vendedores de una tienda
 * 
 * @author MP
 * @version feb-13
 */
public class GestionComisiones {//WMC total 15 CCog total 37

	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) {//+14 +37
		// opciones del menu
		final int NUEVA_VENTA = 0, VENDEDOR_DEL_MES = 1, VENDEDORES = 2;

		// variables auxiliares
		String dni;
		Lectura lect;

		List<Vendedor> vendedores;
		List<Vendedor> resultado;
		String msj;

		// crea la tienda
		Tienda tienda = new Tienda("datosTienda.txt");

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("Anhadir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) {//+1 +1
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) {//+0 +2
			case NUEVA_VENTA://+1
				lect = new Lectura("Datos Venta");
				lect.creaEntrada("DNI Vendedor", "");
				lect.creaEntrada("Importe", "");
				lect.esperaYCierra();
				dni = lect.leeString("DNI Vendedor");
				double importe = lect.leeDouble("Importe");
				try {
					if (!tienda.anhadeVenta(dni, importe)) {//+1 +3
						mensaje("ERROR", "El vendedor no existe");
					}
				} catch (IOException e) {//+0 +3
					mensaje("ERROR", "No se pudo guardar el cambio");
				}
				break;

			case VENDEDOR_DEL_MES://+1

				vendedores = tienda.vendedores();
				resultado = new LinkedList<Vendedor>();
				double maxVentas = 0.0;
				for (Vendedor v : vendedores) {//+1 +3
					if (v.getTotalVentas() > maxVentas) {//+1 +4
						maxVentas = v.getTotalVentas();
						resultado.clear();
						resultado.add(v);
					} else if (v.getTotalVentas() == maxVentas) {//+1 +5
						resultado.add(v);
					}
				}

				msj = "";
				for (Vendedor vn : resultado) {//+1 +3
					msj += vn.getNombre() + "\n";
				}
				mensaje("VENDEDORES DEL MES", msj);
				break;

			case VENDEDORES://+1

				vendedores = tienda.vendedores();
				System.out.println(vendedores.size());
				Collections.sort(vendedores, new Comparator<Vendedor>() {
					public int compare(Vendedor o1, Vendedor o2) {//+1 +0
						if (o1.getTotalVentas()>o2.getTotalVentas())//+1 +4
							return 1;
						else if (o1.getTotalVentas()<o2.getTotalVentas())//+1 +5
							return -1;
						return 0;
					}			
				});
				msj = "";
				for (Vendedor vn : vendedores) {//+1 +3
					msj += vn.getNombre() + " " + vn.getId() + "\n";
				}
				mensaje("VENDEDORES", msj);
				break;
			}
		}
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * 
	 * @param titulo
	 *            titulo de la ventana
	 * @param txt
	 *            texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {//+1 +0
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);
	}

}
