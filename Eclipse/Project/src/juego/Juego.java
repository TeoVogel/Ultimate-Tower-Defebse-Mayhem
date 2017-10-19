package juego;

import java.util.Random;

import grafica.Interfaz;
import juego.ente.Celda;
import juego.ente.Enemigo;

public class Juego {

	private final static Juego juego = new Juego();
	public static Juego getJuego() { return juego; }
	
	private Mapa mapa;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;
	private int puntos;
	Interfaz interfaz;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
	
	private Juego(){
		mercado = new Mercado();
		interfaz = new Interfaz(this);
		interfaz.crearBotonSpawn();
		mapa = new Mapa(this, interfaz);
		int i = 0;

		while (i<3) {
			Random r = new Random();
			int columna = 6 + r.nextInt(3);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				Enemigo e = EnemigoFactory.crearEnemigo2();
				e.init(celda);
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
		mapa.eliminar(e);
		
	}*/
	/* 
	 * SISTEMA DE PUNTOS
	 */
	
	public int getPuntos() {
		return puntos;
	}
	
	public Interfaz getInterfaz(){return interfaz;}
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
