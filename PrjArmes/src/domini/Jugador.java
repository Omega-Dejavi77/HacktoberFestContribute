package domini;

import adaptadorEnemic.FactoriaAdaptadorEnemic;
import adaptadorEnemic.IAdaptadorEnemic;
import estrategiaArmes.FactoriaArmes;
import estrategiaArmes.IEstrategiaArma;

public class Jugador {
	
	private String nom;
	private int vides;
	private IEstrategiaArma arma;
	private IAdaptadorEnemic enemic;
	
	public Jugador (String nom) {
		this.nom = nom;
		this.vides = 14;
		this.arma = FactoriaArmes.getInstancia ().getArma(this);	
		this.enemic = FactoriaAdaptadorEnemic.getInstancia().getAdaptadorEnemic();
	}	

	public int getVides () {
		return this.vides;
	}
	
	public boolean disparar() {
		if (this.vides <= 0){
			throw new IllegalArgumentException ("ERROR disparar: el jugador està mort.");
		}		
		this.arma.disparar();		
		if (enemic.esMort(this)){
			this.vides++;
			canviArma();			
			return true;
		} else {
			this.vides--;
			return false;
		}		
	}
	
	private void canviArma () {
		IEstrategiaArma ar = FactoriaArmes.getInstancia ().getArma(this);
		if (ar.getClass() != this.arma.getClass()){
			this.arma = ar;
		}
	}
	
	public void recarregar (){
		if (this.vides <= 0){
			throw new IllegalArgumentException ("ERROR recarregar: el jugador està mort.");
		}
		this.arma.recarregar();
		this.vides = this.vides / 2;
		canviArma();	
	}

	public int getEficacia() {
		return this.arma.eficacia();
	}
	
	public String getTipusArma (){
		return this.arma.getClass().getSimpleName();
	}
	
	public int getMunicio (){
		return this.arma.getMunicio();
	}
}