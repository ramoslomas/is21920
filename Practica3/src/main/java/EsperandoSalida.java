import java.util.Timer;
import java.util.TimerTask;

public class EsperandoSalida extends AlarmaHogarState{
	protected Timer timer1;
	protected Ejecucion tarea;
	public void entryAction(AlarmaHogar context) {
		timer1 =new Timer();
		tarea= new Ejecucion(context);
		timer1.schedule(tarea, context.getIntervaloSalida());
	}
	
	public void AlarmaOff(AlarmaHogar context, String codigo) {
		if(codigo==context.getCodigoDesactivacion()){
			context.setState(getEstadoApagada());
			context.getState().entryAction(context);
			timer1.cancel();
		}
		
	}
	public class Ejecucion extends TimerTask {
		private AlarmaHogar context;
		public Ejecucion(AlarmaHogar context) {
			this.context=context;
		}
		public void run() {
			context.setState(getEstadoActivada());
			context.getState().entryAction(context);
			context.getPiloto().encender();
		}
	}
	
}

