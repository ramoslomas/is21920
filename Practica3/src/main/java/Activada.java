
public class Activada extends AlarmaHogarState{
	public void entryAction(AlarmaHogar context) {
		context.activarSensores(context);
	}
	
	public void intruso(AlarmaHogar context) {
		
		context.setState(AlarmaHogarState.getEstadoEsperandoDesactivacion());
		context.getState().entryAction(context);
	}
}
