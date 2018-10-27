package estrategiaArmes;

public class Arc implements IEstrategiaArma {
	
	private int fletxes;
	
	public Arc () {
		this.recarregar();
	}

	@Override
	public void disparar() {
		if (this.fletxes > 0){
			this.fletxes--;
		} else {
			throw new IllegalArgumentException ("No pots disparar, no tens més fletxes");
		}
	}

	@Override
	public void recarregar() {
		if (this.fletxes <= 0){
			this.fletxes = 5;
		} else {
			throw new IllegalArgumentException ("No pots obtenir més fletxes, encare en tents ." + this.fletxes);
		}
	}

	@Override
	public int eficacia() {
		return 30;
	}

	@Override
	public int getMunicio() {
		return this.fletxes;
	}	
}