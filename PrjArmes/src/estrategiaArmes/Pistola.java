package estrategiaArmes;

public class Pistola implements IEstrategiaArma {
	
	private int bales;

	public Pistola () {
		this.bales = 16;
	}
	@Override
	public void disparar() {
		if (this.bales > 0){
			this.bales--;
		} else {
			throw new IllegalArgumentException ("No pots disparar, no tens més bales");
		}
	}

	@Override
	public void recarregar() {
		if (this.bales <= 0){
			this.bales = 16;
		} else {
			throw new IllegalArgumentException ("No pots obtenir més bales, encare en tents ." + this.bales);
		}
	}
	
	@Override
	public int eficacia() {
		return 60;
	}
	
	@Override
	public int getMunicio() {
		return this.bales;
	}	
}