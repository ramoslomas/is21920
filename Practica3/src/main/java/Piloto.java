
public class Piloto {
	private int estado=0;
	//0=apagado,1=encendido,2=intermitente
	public void encender() {
		estado=1;
	}
	
	public void apagar() {
		estado=0;
	}
	
	public void parpadear() {
		estado=2;
	}
	public int getState() {
		return estado;
	}
}
