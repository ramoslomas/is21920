package modelo;

import java.time.LocalDate;

public class Empleado {
	public String nombre;
	public LocalDate fechaContratacion;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoria;
	double sueldo;
	
	@SuppressWarnings("serial")
	public class DatoIncorrectoException extends Exception{};
	
	public Empleado(String nombre,LocalDate fechaContratacion, boolean baja, Categoria categoria){
		this.nombre=nombre;
		this.fechaContratacion=fechaContratacion;
		this.baja=baja;
		this.categoria=categoria;
		sueldo=0;
	}
	
	public double sueldoBruto() throws DatoIncorrectoException{
		if(fechaContratacion.isAfter(LocalDate.now())) {
			throw new DatoIncorrectoException();
		}
		switch(categoria) {
			case DIRECTIVO:
				sueldo=1500;
				break;
			case GESTOR:
				sueldo=1200;
				break;
			case OBRERO:
				sueldo=1000;
				break;
		}
		
		if (baja) {
			sueldo=sueldo*0.75;
		}
		
		if(fechaContratacion.isBefore(LocalDate.now().minusYears(20).plusDays(1))) {
			sueldo=sueldo+200;
		}else if(fechaContratacion.isBefore(LocalDate.now().minusYears(10).plusDays(1))){
			sueldo=sueldo+100;
		}else if(fechaContratacion.isBefore(LocalDate.now().minusYears(5).plusDays(1))) {
			sueldo=sueldo+50;
		}
		
		return sueldo;
		
	}
	
	
	public boolean darDeAlta() throws DatoIncorrectoException{
		baja=false;
		return baja;
		
	}
	
	public boolean darDeBaja() throws DatoIncorrectoException{
		baja=true;
		return baja;
		
	}

}
