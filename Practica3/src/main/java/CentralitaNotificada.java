
public class CentralitaNotificada extends AlarmaHogarState{
	
	public void off (AlarmaHogar context) {
		context.setState(getEstadoApagada());
		context.getState().entryAction(context);
	}
	
	
	public void entryAction(AlarmaHogar context) {
		context.notificarCentralita();
	}
}
