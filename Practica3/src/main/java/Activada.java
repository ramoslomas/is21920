
public class Activada extends AlarmaHogarState{
	public void entryAction(AlarmaHogar context) {
		context.activarSensores();
		System.out.println("se activan los sensores");
	}
	
	public void intruso(AlarmaHogar context) {
		
		context.setState(AlarmaHogarState.getEstadoEsperandoDesactivacion());
		context.getState().entryAction(context);
	}
}
