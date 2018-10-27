package adaptadorEnemic;

import calcul.CalculTirShoot;
import domini.Jugador;

public class AdaptadorShootWar implements IAdaptadorEnemic {

	public boolean esMort(Jugador jugador) {
		if (jugador == null) {
			throw new IllegalArgumentException("ERROR enemic és mort: el jugador no pot ser nul.");
		}
		int eficacia = jugador.getEficacia();
		if (eficacia < 1) {
			eficacia = 5;
		}
		return CalculTirShoot.calcularTir(eficacia, jugador.getVides());
	}
}
