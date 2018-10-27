package estrategiaArmes;

public class Escopeta implements IEstrategiaArma {

	private int cartuxos;
	
	public Escopeta() {
		this.cartuxos = 2;
	}
	
	@Override
	public void disparar() {
		if (this.cartuxos > 0)
			this.cartuxos--;
		else
			throw new IllegalArgumentException("No pots disparar, no tens més cartuxos");
	}

	@Override
	public void recarregar() {
		if (this.cartuxos <= 0)
			this.cartuxos = 2;
		else
			throw new IllegalArgumentException ("No pots obtenir més cartuxos, encare en tens ." + this.cartuxos);	
	}

	@Override
	public int eficacia() {
		return 80;
	}

	@Override
	public int getMunicio() {
		return this.cartuxos;
	}

}
