package juego;

import java.util.Random;

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
	
	private Juego(){
		mercado = new Mercado();
		mapa = new Mapa();
		int i = 0;

		while (i<3) {
			Random r = new Random();
			int columna = 6 + r.nextInt(3);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				Enemigo e = FactoryEnemigo.crearEnemigo1();
				e.init(celda);
				mapa.addEnemigo(e);
				i++;
			}
		}
		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
		
		Nivel nivel = new Nivel1(2, mapa);
		nivel.start();
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
	
	public Interfaz getInterfaz(){return mapa.interfaz;}
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
