package grafica;

import juego.Constantes;
import juego.ente.Ente;
import juego.ente.powerup.PowerUp;

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo = new RayoLaserAliado();
	
	public GraficoPersonaje(Ente e, String n) {
		super(e, n);
	}
	
	public void setPowerUp (PowerUp p) {
		if (!inicializado) {
			return;
		}
		
		powerUp.setIcon(p.getImg());
		powerUp.setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
	}

	public void graficarDisparo(Ente e1, Ente e2) {
		disparo.graficar(e1.getGrafico(), e2.getGrafico());
	}
}