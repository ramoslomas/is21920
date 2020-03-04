
public class Apagada extends AlarmaHogarState{
	
	public void entryAction(AlarmaHogar context) {
		context.getPiloto().apagar();
		desactivarSensores(context);
		context.setIntentos(0);
	}
	
	public void alarmaOn(AlarmaHogar context) {
		context.getPiloto().parpadear();
		context.setState(estadoEsperandoSalida);
		System.out.println("se cambia el estado");
		context.getState().entryAction(context);
	}
	
	
}



