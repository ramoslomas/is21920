package listaOrdenadaAcotada;

public interface IListaAcotada<E> {
	

	/**
	 * Lectura posicional: Retorna el elemento que ocupa la
	 * posicin indicada
	 * @param indice
	 * @return Elemento que ocupa la posicin indice
	 * @throws IndexOutOfBoundsException si el indice es incorrecto
	 */
    public E get(int indice);
    //casos validos: indice valido
    //casos no validos: nulo, indice mayor que tamaño
    
    /**
     * Aade un elemento en la posicin que le corresponde
     * @param elemento a aadir
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
    public void add(E elemento);
    //casos validos:
    //casos no validos
    
    /**
     * Elimina el elemento que ocupa la posicin indicada
     * @param indice Posicin del elemento a eliminar
     * @return Elemento que ocupaba la posicin indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
    public E remove(int indice);
    
    /**
     * Retorna el tamao de la lista
     * @return Tamao de la lista
     */
    public int size();
    
    /**
     * Hace nula la lista
     */
     public void clear();
     
}