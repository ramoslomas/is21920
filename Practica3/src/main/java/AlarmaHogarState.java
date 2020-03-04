
public abstract class AlarmaHogarState {
	
	protected static Activada estadoActivada = new Activada();
	protected static EsperandoSalida estadoEsperandoSalida = new EsperandoSalida();
	protected static Apagada estadoApagada = new Apagada();
	protected static EsperandoDesactivacion estadoEsperandoDesactivacion = new EsperandoDesactivacion();
	protected static CentralitaNotificada estadoCentralitaNotificada = new CentralitaNotificada();
	
	
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
