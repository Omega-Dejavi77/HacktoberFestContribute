package adaptadorEnemic;

import persistencia.FitxerConfiguracio;

public class FactoriaAdaptadorEnemic {

	private static FactoriaAdaptadorEnemic instancia;
	private IAdaptadorEnemic enemic;

	private FactoriaAdaptadorEnemic() {
		try {
			String name = FitxerConfiguracio.getFitxer();
			Class<?> c = Class.forName(name);
			this.enemic = (IAdaptadorEnemic)c.newInstance();
		}
		catch (Exception e) {
			this.enemic = new AdaptadorCalculTirFG();
		}
	}

	public synchronized static FactoriaAdaptadorEnemic getInstancia() {
		if (instancia == null) {
			instancia = new FactoriaAdaptadorEnemic();
		}
		return instancia;
	}

	public IAdaptadorEnemic getAdaptadorEnemic() {
		return this.enemic;
	}
}
