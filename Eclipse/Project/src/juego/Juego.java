package juego;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import grafica.Interfaz;
import juego.ente.Celda;
import juego.ente.Ente;
import juego.ente.Enemigo;
import juego.niveles.Nivel;
import juego.niveles.Nivel1;
import juego.niveles.Nivel2;
import juego.niveles.Nivel3;

public class Juego {

	private final static Juego juego = new Juego();
	public static Juego getJuego() { return juego; }
	
	private Mapa mapa;
	private Interfaz interfaz;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;
	private int puntos;
	
	private final int DIFICULTAD = 2;
	private final int MONEDAS_INICIALES = 1000;
	private List<Nivel> niveles = new ArrayList<Nivel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
	
	private Juego(){
		mercado = new Mercado(MONEDAS_INICIALES);
		interfaz= new Interfaz(this);
		mapa = new Mapa(interfaz.getPanelMapa());
		int i = 0;		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
		
		niveles.add(new Nivel1(mapa, DIFICULTAD));
		//niveles.add(new Nivel2(mapa, DIFICULTAD));
		//niveles.add(new Nivel3(mapa, DIFICULTAD));
		siguienteNivel();
		
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}
	
	public void detonarBomba(int fila, int columna) {
		interfaz.getPanelMapa().graficarBomba(fila, columna);
		Celda centro = mapa.getCelda(fila, columna);
		Celda[] perimetro = {centro.getAbajo(), centro.getArriba(), centro.getIzq(), centro.getDer()};
		
		if (centro.getEnte() != null)
			centro.getEnte().quitarVida(100);
		
		for (int i = 0; i < 4; i++)
			if (perimetro[i] != null)
				if (perimetro[i].getEnte() != null)
					perimetro[i].getEnte().quitarVida(50);
}

	/* 
	 * SISTEMA DE PUNTOS
	 */
	
	public int getPuntos() {
		return puntos;
	}
	
	public Interfaz getInterfaz(){
		return interfaz;
	}
	
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
		interfaz.dispatchEvent(new WindowEvent(interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	public void ganar () {
		JOptionPane.showMessageDialog(null, "You win!");
		interfaz.dispatchEvent(new WindowEvent(interfaz, WindowEvent.WINDOW_CLOSING));
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
