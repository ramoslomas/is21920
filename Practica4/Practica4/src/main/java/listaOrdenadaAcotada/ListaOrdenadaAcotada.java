package listaOrdenadaAcotada;



public class ListaOrdenadaAcotada<E extends Comparable<E>> implements IListaAcotada<E> {
	public static final int MAX_POR_OMISION = 10;

	private E[] lista;

	private int ultimo;

	public ListaOrdenadaAcotada(int max) {
		this.lista = (E[])new Comparable[max];
		this.ultimo = -1;
	}

	public ListaOrdenadaAcotada() {
		this(10);
	}

	public E get(int indice) {
		if(indice>this.lista.length-1) {
			throw new IndexOutOfBoundsException();
		}
		return this.lista[indice];
	}

	public void add(E elemento) {
		if (this.ultimo == this.lista.length - 1)
			throw new IllegalStateException(); 
		int indice = 0;
		if (this.ultimo != -1)
			while (indice <= this.ultimo && elemento.compareTo(this.lista[indice]) > 0)
				indice++;
		for (int i = this.ultimo; i >= indice; i--)
			this.lista[i + 1] = this.lista[i]; 
		this.lista[indice] = elemento;
		this.ultimo++;
	}

	public E remove(int indice) {
		if (indice > this.ultimo)
			throw new IndexOutOfBoundsException(); 
		E borrado = this.lista[indice];
		for (int i = indice + 1; i <= this.ultimo; i++)
			this.lista[i - 1] = this.lista[i]; 
		this.ultimo--;
		return borrado;
	}

	public int size() {
		return this.ultimo + 1;
	}

	public void clear() {
		this.ultimo = -1;
	}
}