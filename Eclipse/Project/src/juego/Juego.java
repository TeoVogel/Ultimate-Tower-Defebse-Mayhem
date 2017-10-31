package juego;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import grafica.Interfaz;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.niveles.Nivel;
import juego.niveles.Nivel1;

public class Juego {

	private final static Juego juego = new Juego();
	public static Juego getJuego() { return juego; }
	
	private Mapa mapa;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;
	private int puntos;
	
	private int dificultad = 4;
	private List<Nivel> niveles = new ArrayList<Nivel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
	
	private Juego(){
		mercado = new Mercado();
		mapa = new Mapa();
		int i = 0;		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
		
		niveles.add(new Nivel1(mapa, dificultad));
		siguienteNivel();
		
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}

	/* 
	 * SISTEMA DE PUNTOS
	 */
	
	public int getPuntos() {
		return puntos;
	}
	
	public Interfaz getInterfaz(){return mapa.interfaz;}
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	public void siguienteNivel () {
		if (niveles.size() > 0) {
			niveles.remove(0).init();
		} else {
			ganar();
		}
	}
	
	public void perder () {
		JOptionPane.showMessageDialog(null, "You lose!");
		mapa.interfaz.dispatchEvent(new WindowEvent(mapa.interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	public void ganar () {
		JOptionPane.showMessageDialog(null, "You win!");
		mapa.interfaz.dispatchEvent(new WindowEvent(mapa.interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
