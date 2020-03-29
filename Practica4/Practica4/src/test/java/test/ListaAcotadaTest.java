package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


import listaOrdenadaAcotada.ListaOrdenadaAcotada;
import modelo.ListaOrdenada;

public class ListaAcotadaTest {

	@Test
	public void testGetAdd(){
		//casos validos
		
		//anadimos un elemento a una cola vacia
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			assertTrue(lista.get(0)==1);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//anadimos un elemento a una lista con un elemento
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(2);
			assertTrue(lista.get(0)==1);
			assertTrue(lista.get(1)==2);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//anadimos un elemento a una lista con mas de un elemento
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(2);
			lista.add(3);
			assertTrue(lista.get(0)==1);
			assertTrue(lista.get(1)==2);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//comprobamos que la lista este ordenada por orden cronologico
		
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(3);
			lista.add(2);
			System.out.println(lista.get(0));
			System.out.println(lista.get(1));
			System.out.println(lista.get(2));
			
			assertTrue(lista.get(0)==1);
			assertTrue(lista.get(1)==2);
			assertTrue(lista.get(2)==3);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			lista.clear();
			lista.add(1);
			assertTrue(lista.get(0)==1);
			
		}catch(IllegalStateException e) {
			
		}
	
		//casos no validos
		//hacer get de un elemento que esta fuera del tamano de la lista
		
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(2);
			lista.get(15);
			fail("Deberia fallar");
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.get(10);
			fail("Deberia fallar");
		}catch(IndexOutOfBoundsException e) {
			
		}
		
	}
	

	
	@Test
	public void testRemove() {
		//casos validos
		
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.remove(0);
	
		}catch(IndexOutOfBoundsException e) {
			
		}
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(2);
			lista.remove(0);
			assertTrue(lista.get(0)==2);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//casos no validos
		
		//Remover un elemento de una cola vacía
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.remove(0);
			fail("Debería fallar");
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//Remover un elemento con un indice fuera del tamaño de la lista
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			
			lista.add(1);
			lista.add(2);
			lista.remove(3);
			fail("debería fallar");
		}catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testSize() {
		//casos validos
		//lista vacia
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			assertTrue(lista.size()==0);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//Comprobar que cambia el tamano cuando anadimos o removemos elementos
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			int tamano=lista.size();
			lista.add(3);
			assertTrue(lista.size()-1==tamano);
			lista.remove(0);
			assertTrue(lista.size()==tamano);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//casos no validos
	}
	
	@Test
	public void clear() {
		//casos validos
		//lista vacia
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			lista.clear();
			assertTrue(lista.size()==0);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//lista con un elemento
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			lista.add(1);
			lista.clear();
			assertTrue(lista.size()==0);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//lista con mas de un elemento
		try {
			ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>();
			lista.add(1);
			lista.add(2);;
			lista.clear();
			assertTrue(lista.size()==0);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
		//casos no validos
	}
}
