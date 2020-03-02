import java.util.Timer;
import java.util.TimerTask;

public class EsperandoDesactivacion extends AlarmaHogarState{
	
	protected Timer timer2;
	protected Ejecucion tarea;
	public void entryAction(AlarmaHogar context) {
		timer2 =new Timer();
		tarea= new Ejecucion(context);
		timer2.schedule(tarea, context.getIntervaloSalida());
	}
	public void AlarmaOff(AlarmaHogar context, String codigo) {
		
		
		int intentos=context.getIntentos();
		
		if(codigo==context.getCodigoDesactivacion() && intentos<3){
			context.setState(getEstadoApagada());
			context.getState().entryAction(context);
		}else {
			intentos=intentos+1;
			context.setIntentos(intentos);
		}
	}
	
	
	public class Ejecucion extends TimerTask {
		private AlarmaHogar context;
		public Ejecucion(AlarmaHogar context) {
			this.context=context;
		}
		public void run() {
			context.setState(getEstadoCentralitaNotificada());
			context.getState().entryAction(context);
		}
	}
}
