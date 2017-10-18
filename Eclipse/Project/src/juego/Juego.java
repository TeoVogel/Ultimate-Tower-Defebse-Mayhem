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
import juego.ente.Enemigo1;


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
		createMarket();
		mapa = new Mapa(this, interfaz);
		int i = 0;
		while (i<3) {
			Random r = new Random();
			int columna = 4 + r.nextInt(5);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				Enemigo e = EnemigoFactory.crearEnemigo1(celda);
				e.init(celda);
				mapa.addEnemigo(e);
				i++;
			}
		}
		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	private void createMarket () {
		//mercado = new Mercado();
		
		JButton buttonE = new JButton("SpawE");
		buttonE.setBounds(0, 0, 100, 50);
		interfaz.add(buttonE);
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mercado.addToPlaceHolder(new AccionSpawnearEnemigo(getThis()));
			}			
		});
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
	
	public void sumarPuntos (int p) {
		puntos += p;
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
