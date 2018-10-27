package estrategiaArmes;

import domini.Jugador;

public class FactoriaArmes {
	
	private static FactoriaArmes instancia;
	
	private FactoriaArmes () {}
	
	public synchronized static FactoriaArmes getInstancia (){
		if (instancia == null){
			instancia = new FactoriaArmes();
		}
		return instancia;		
	}

	public IEstrategiaArma getArma(Jugador jugador) {
		if (jugador == null){
			throw new IllegalArgumentException ("ERROR getArma: el jugador no pot ser nul.");
		}
		int vides = jugador.getVides();
		if (vides <= 0){
			throw new IllegalArgumentException ("ERROR getArma: el jugador està mort.");
		}
		if (vides > 0 && vides <= 7){
			return new Arc();
		}
		else if (vides <= 10) {
			return new Pistola();
		}
		else
			return new Escopeta();
	}
}