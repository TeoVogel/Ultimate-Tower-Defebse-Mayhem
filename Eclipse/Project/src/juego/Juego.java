package juego;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

import grafica.Interfaz;
import juego.acciones.AccionSpawnearAliado;
import juego.acciones.AccionSpawnearEnemigo;
import juego.ente.Celda;
import juego.ente.Enemigo;


public class Juego {
	private Interfaz interfaz;
	private Mapa mapa;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;
	private int puntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	public Juego(){
		interfaz= new Interfaz(this);
		createMarket();
		mapa= new Mapa(this, interfaz);
		int i = 0;
		while (i<2) {
			Random r = new Random();
			int columna = 4 + r.nextInt(5);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				mapa.addEnemigo(EnemigoFactory.crearEnemigo1(celda));
				i++;
			}
		}
		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	private void createMarket () {
		mercado = new Mercado();
		interfaz.SpawnE();
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}
	
	public void ejecutarMercado(int fila, int columna){
		if (mercado.isPlaceHolderFull()) {
			mercado.getPlaceHolderContent().ejecutar(mapa.getCelda(fila, columna));
		}	
	}
	public void SpawnE(){
		mercado.addToPlaceHolder(new AccionSpawnearEnemigo(getThis()));
	}	
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
