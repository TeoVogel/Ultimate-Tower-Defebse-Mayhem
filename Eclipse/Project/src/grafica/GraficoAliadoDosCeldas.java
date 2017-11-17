package grafica;

import juego.Juego;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.powerup.PowerUp;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import grafica.GraficoDisparo;
import grafica.RayoLaserAliadoDosCeldas;

public class GraficoAliadoDosCeldas extends GraficoAliado {
	
	public GraficoAliadoDosCeldas(Ente e, String n) {
		super(e, n);
	}
	
	@Override
	public void initGrafico (Celda c) {
		inicializado = true;
		pos = new Point(calcularX(c), calcularY(c));
		setIcon(image[0]);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, 2*PanelMapa.TILE_HIGHT);
		
		
		barraVida = new JLabel();
		barraVida.setBackground(Color.GREEN);
		barraVida.setOpaque(true);
	    this.getParent().add(barraVida);
	    
		powerUp = new JLabel();
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, 2*PanelMapa.TILE_HIGHT);
		this.getParent().add(powerUp);
	    
		actualizarVida();
	
	
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Juego.getJuego().getMercado().isAccionSobreAliado()) {
					Juego.getJuego().getMercado().getAccionSobreAliado().ejecutar((Aliado)ente);
				}
			}
			
		});
	}
	
	@Override
	public void cambiarGrafico(EstadoEnte estado) {
		if (!inicializado) {
			return;
		}
		
		setIcon(image[estado.getIndex()]);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, 2*PanelMapa.TILE_HIGHT);
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, 2*PanelMapa.TILE_HIGHT);
		repaint();
		actualizarVida();
	}
	
	@Override
	public void actualizarVida () {		
		if (!inicializado) {
			return;
		}
		
		int max = ente.getMaxVida();
		int vida = ente.getVida();
		
		int barraLenght = BARRA_VIDA_WIDTH*vida/max;
		
		int barraWidthOffset = (PanelMapa.TILE_WIDTH - barraLenght)/2;
		int barraHeightOffset = 2*PanelMapa.TILE_HIGHT - BARRA_VIDA_HIGHT/2;
		
		barraVida.setBounds(pos.x + barraWidthOffset, pos.y + barraHeightOffset, barraLenght, BARRA_VIDA_HIGHT);
	}
	
	@Override
	public void setPowerUp (PowerUp p) {
		if (!inicializado) {
			return;
		}
		
		powerUp.setIcon(p.getImg());
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, 2*PanelMapa.TILE_HIGHT);
	}
	
}
