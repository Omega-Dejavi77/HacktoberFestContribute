package adaptadorEnemic;

import calcul.CalculTirFG;
import domini.Jugador;

public class AdaptadorCalculTirFG implements IAdaptadorEnemic {

	public boolean esMort(Jugador jugador) {
		if (jugador == null) {
			throw new IllegalArgumentException("ERROR enemic és mort: el jugador no pot ser nul.");
		}
		int eficacia = jugador.getEficacia();
		if (eficacia < 1) {
			eficacia = 5;
		}
		return CalculTirFG.calcularTir(eficacia);
	}
}