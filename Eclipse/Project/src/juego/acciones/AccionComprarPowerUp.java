package juego.acciones;

import juego.ente.Aliado;
import juego.ente.powerup.FactoryPowerUps;
import juego.ente.powerup.PowerUp;
import juego.Juego;

public class AccionComprarPowerUp implements AccionSobreAliado {

	private PowerUp powerUp;
	
	public AccionComprarPowerUp (int tipo) {
		this.powerUp = FactoryPowerUps.getPowerUp(tipo);
	}
	
	public void ejecutar (Aliado a) {
		a.setPowerUp(powerUp);
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return powerUp.getPrecio();
	}
	
}
