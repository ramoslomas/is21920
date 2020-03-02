
public class Apagada extends AlarmaHogarState{
	
	public void entryAction(AlarmaHogar context) {
		context.desactivarSensores(context);
		context.getPiloto().apagar();
		context.setIntentos(0);
	}
	
	public void AlarmaOn(AlarmaHogar context) {
		context.getPiloto().parpadear();
		context.setState(getEstadoEsperandoSalida());
		context.getState().entryAction(context);
	}
	
	
}



