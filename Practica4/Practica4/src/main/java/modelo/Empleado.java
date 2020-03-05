package modelo;

import java.time.LocalDate;

public class Empleado {
	public String nombre;
	public LocalDate fechaContratacion;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoria;
	
	public Empleado(String nombre,LocalDate fechaContratacion, boolean baja, Categoria categoria){
		this.nombre=nombre;
		this.fechaContratacion=fechaContratacion;
		this.baja=baja;
		this.categoria=categoria;
	}
	
	public double sueldoBruto(){
		double sueldo=0;
		switch(categoria) {
			case DIRECTIVO:
				sueldo=1500;
				break;
			case GESTOR:
				sueldo=1200;
				break;
			case OBRERO:
				sueldo=100;
				break;
		}
		
		return sueldo;
		
	}
	
	
	public boolean darDeAlta() {
		baja=false;
		return baja;
		
	}
	
	public boolean darDeBaja() {
		baja=true;
		return baja;
		
	}
}
