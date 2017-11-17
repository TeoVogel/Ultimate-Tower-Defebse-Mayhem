package grafica;

import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import juego.ente.Celda;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.EstadoEnteAtacar;
import juego.ente.EstadoEnteParar;
import juego.ente.powerup.PowerUp;

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo;
	protected JLabel powerUp;
	
	public GraficoPersonaje(Ente e, String n , GraficoDisparo d) {
		super(e, n);
		disparo = d;
	}

	public void initGrafico (Celda c) {
		super.initGrafico(c);
		powerUp = new JLabel();
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		this.getParent().add(powerUp);
	}
	
	public void cambiarGrafico(EstadoEnte estado) {
		super.cambiarGrafico(estado);
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		repaint();
	}
	
	public void centrar (){
		super.centrar();
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
	}
	
	public void morir () {
		super.morir();
		powerUp.setVisible(false);
		this.getParent().remove(powerUp);
	}
	
	public void setPowerUp (PowerUp p) {
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