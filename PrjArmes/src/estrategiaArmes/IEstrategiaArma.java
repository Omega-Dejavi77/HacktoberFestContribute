package estrategiaArmes;

public interface IEstrategiaArma {
	
	public void disparar();
	
	public void recarregar();
	
	public int eficacia ();

	public int getMunicio();
}