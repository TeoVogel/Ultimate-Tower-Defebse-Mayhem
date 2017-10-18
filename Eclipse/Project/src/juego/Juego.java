package juego;

import java.util.Random;

import grafica.Interfaz;
import juego.ente.Celda;
import juego.ente.Enemigo;



public class Juego {

	private Mapa mapa;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;
	private int puntos;
	Interfaz interfaz;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	public Juego(){
		mercado = new Mercado();
		interfaz=new Interfaz(this);
		interfaz.crearBotonSpawn();
		mapa = new Mapa(this, interfaz);
		int i = 0;
		while (i<3) {
			Random r = new Random();
			int columna = 4 + r.nextInt(5);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				Enemigo e = EnemigoFactory.crearEnemigo1(celda);
				mapa.addEnemigo(e);
				i++;
			}
		}
		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}
	
	/*public void eliminarEnte(Ente e) {
		mapa.
		
	}*/
	/* 
	 * SISTEMA DE PUNTOS
	 */
	
	public int getPuntos() {
		return puntos;
	}
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
