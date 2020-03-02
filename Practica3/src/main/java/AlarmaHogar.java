
public class AlarmaHogar {
	
	private AlarmaHogarState state;
	private int intervaloSalida;
	private int intervalosDesactivacion;
	private String codigoDesactivacion;
	private Piloto piloto;
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public void setMaxintentos(int maxintentos) {
		this.maxintentos = maxintentos;
	}
	private int intentos=0;
	private int maxintentos=3;
	
	public int getMaxintentos() {
		return maxintentos;
	}
	public AlarmaHogar() {
		state=AlarmaHogarState.init(this);
		intervaloSalida=15000;
		intervalosDesactivacion=20000;
		codigoDesactivacion="9999";
	}
	public void setState(AlarmaHogarState value) {
		this.state = value;
	}
	public void notificarCentralita() {
		state.notificarCentralita(this);
	}
	
	public void alarmaOff(String codigo,AlarmaHogar context) {
		
	}
	
	public void alarmaOn(AlarmaHogar context) {
		
	}
	
	public void intruso(AlarmaHogar context) {
		
	}
	
	public void off(AlarmaHogar context) {
		
	}
	
	public void activarSensores(AlarmaHogar context) {
		
	}
	
	public void desactivarSensores(AlarmaHogar context) {
		
	}
	
	public AlarmaHogarState getState() {
		return state;
		
	}
	public int getIntervaloSalida() {
		return intervaloSalida;
	}
	public void setIntervaloSalida(int intervaloSalida) {
		this.intervaloSalida = intervaloSalida;
	}
	public int getIntervalosDesactivacion() {
		return intervalosDesactivacion;
	}
	public void setIntervalosDesactivacion(int intervalosDesactivacion) {
		this.intervalosDesactivacion = intervalosDesactivacion;
	}
	public String getCodigoDesactivacion() {
		return codigoDesactivacion;
	}
	public void setCodigoDesactivacion(String codigoDesactivacion) {
		this.codigoDesactivacion = codigoDesactivacion;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
}
