
public abstract class AlarmaHogarState {
	
	private static AlarmaHogarState estadoActivada = new Activada();
	private static AlarmaHogarState estadoEsperandoSalida = new EsperandoSalida();
	private static AlarmaHogarState estadoApagada = new Apagada();
	private static AlarmaHogarState estadoEsperandoDesactivacion = new EsperandoDesactivacion();
	private static AlarmaHogarState estadoCentralitaNotificada = new CentralitaNotificada();
	
	
	public static AlarmaHogarState init(AlarmaHogar context) {
		estadoApagada.entryAction(context);
		return estadoApagada;
	}
	public void alarmaOff(String codigo, AlarmaHogar context) {
		
	}
	
	public void alarmaOn(AlarmaHogar context) {
		
	}
	public void notificarCentralita(AlarmaHogar context){
		
	}
	
	public void off(AlarmaHogar context) {
		
	}
	
	public void activarSensores(AlarmaHogar context) {
		
	}
	
	public void desactivarSensores(AlarmaHogar context) {
		
	}
	
	public void intruso(AlarmaHogar context) {
		
	}
	
	public void entryAction(AlarmaHogar context) {
		
	}
	
	public void doAction(AlarmaHogar context) {
		
	}
	
	public void exitAction(AlarmaHogar context) {
		
	}
	
	
	public static AlarmaHogarState getEstadoActivada() {
		return estadoActivada;
	}
	
	public static AlarmaHogarState getEstadoEsperandoSalida() {
		return estadoEsperandoSalida;
	}
	
	public static AlarmaHogarState getEstadoApagada() {
		return estadoApagada;
	}
	
	public static AlarmaHogarState getEstadoEsperandoDesactivacion() {
		return estadoEsperandoDesactivacion;
	}
	
	public static AlarmaHogarState getEstadoCentralitaNotificada() {
		return estadoCentralitaNotificada;
	}
	
}
