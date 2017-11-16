package grafica;

import juego.Constantes;
import juego.ente.Ente;
import juego.ente.EstadoEnteAtacar;
import juego.ente.EstadoEnteParar;
import juego.ente.powerup.PowerUp;

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo;
	
	public GraficoPersonaje(Ente e, String n , GraficoDisparo d) {
		super(e, n);
		disparo= d;
	}
	
	public void setPowerUp (PowerUp p) {
		if (!inicializado) {
			return;
		}
		
		powerUp.setIcon(p.getImg());
		powerUp.setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
	}

	public void graficarDisparo(Ente e1, Ente e2) {
		cambiarGrafico(new EstadoEnteAtacar());
		disparo.graficar(e1.getGrafico(), e2.getGrafico());
//		cambiarGrafico(new EstadoEnteParar());
	}
}