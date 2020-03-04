import java.util.Timer;
import java.util.TimerTask;

public class EsperandoDesactivacion extends AlarmaHogarState{
	
	protected Timer timer2;
	protected Ejecucion tarea;
	public void entryAction(AlarmaHogar context) {
		context.getPiloto().parpadear();
		timer2 =new Timer();
		tarea= new Ejecucion(context);
		timer2.schedule(tarea, context.getIntervaloSalida());
	}
	public void alarmaOff(AlarmaHogar context, String codigo) {
		
		System.out.println("PASO2");
		int intentos=context.getIntentos();
		
		if(codigo.equals(context.getCodigoDesactivacion()) && intentos<context.getMaxintentos()){
			context.setState(getEstadoApagada());
			context.getState().entryAction(context);
		}else {
			System.out.println("codigo erroneo");
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
			context.getPiloto().encender();
		}
	}
}
