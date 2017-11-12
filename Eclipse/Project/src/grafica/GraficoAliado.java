	package grafica;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.EstadoEnteParar;
import juego.ente.Obstaculo;
import juego.Constantes;
import juego.Juego;

public class GraficoAliado extends GraficoPersonaje {

	public GraficoAliado(Ente e, String n) {
		super(e, n);
	}
	
	public void initGrafico (Celda c) {
		super.initGrafico(c);
	
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Juego.getJuego().getMercado().isPlaceHolderFull()) {
					Juego.getJuego().getMercado().getPlaceHolderContent().ejecutar(ente.getCelda());
				}
			}
			
		});
	}

	
}