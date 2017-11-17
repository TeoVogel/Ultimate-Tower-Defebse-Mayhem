package grafica;

import juego.Constantes;
import juego.Juego;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.EstadoEnteAtacar;
import juego.ente.EstadoEnteParar;
import juego.ente.powerup.PowerUp;

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo;
	
	public GraficoPersonaje(Ente e, String n , GraficoDisparo d) {
		super(e, n);
		disparo = d;
	}
	
	public void setPowerUp (PowerUp p) {
		if (!inicializado) {
			return;
		}
		
		powerUp.setIcon(p.getImg());
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
	}

	public void graficarDisparo(Ente e1, Ente e2) {
		EstadoEnte estado = new EstadoEnteAtacar();
		e1.setEstado(estado);
		cambiarGrafico(estado);
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 10);
		disparo.graficar(e1.getGrafico(), e2.getGrafico());
	}
}