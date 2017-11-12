package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.powerup.PowerUp;
import juego.FactoryAliado;
import juego.Juego;

public class AccionComprarPowerUp implements AccionSobreAliado {

	private PowerUp powerUp;
	
	public AccionComprarPowerUp (PowerUp powerUp) {
		this.powerUp = powerUp;
	}
	
	public void ejecutar (Aliado a){
		a.setPowerUp(powerUp);;
		Juego.getJuego().getMercado().quitarMonedas(getPrecio());
	}
	
	public int getPrecio () {
		return powerUp.getPrecio();
	}
	
}
