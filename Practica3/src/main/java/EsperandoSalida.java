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
	
	public void alarmaOff(String codigo,AlarmaHogar context ) {
		if(codigo.equals(context.getCodigoDesactivacion())){
			context.setState(estadoApagada);
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
			context.setState(estadoActivada);
			context.getState().entryAction(context);
			context.getPiloto().encender();
		}
	}
	
}

