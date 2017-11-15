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

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo = new RayoLaserAliado();
	
	public GraficoPersonaje(Ente e, String n) {
		super(e, n);
	}

	public void graficarDisparo(Ente e1, Ente e2) {
		disparo.graficar(e1.getGrafico(), e2.getGrafico());
	}
}