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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	public Juego(){
		mapa = new Mapa(this);
		createMarket();

		int i = 0;
		while (i<5) {
			Random r = new Random();
			int columna = 4 + r.nextInt(5);
			int fila = r.nextInt(5);
			Celda celda = mapa.getCelda(fila, columna);
			if (celda.getEnte() == null) {
				mapa.addEnemigo(EnemigoFactory.crearEnemigo(celda));
				i++;
			}
		}
		
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	private void createMarket () {
		mercado = new Mercado();
		
		JButton buttonE = new JButton("SpawE");
		buttonE.setBounds(0, 0, 100, 50);
		mapa.add(buttonE);
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				//mercado.addToPlaceHolder(new AccionSpawnearEnemigo(crearEnemigo(), getThis()));
				mapa.addEnemigo(crearEnemigo(), 0, 0);
=======
				mercado.addToPlaceHolder(new AccionSpawnearEnemigo(getThis()));
>>>>>>> c97a0f3bd529248bad62fe74a1c300753fd99822
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
	
<<<<<<< HEAD

	private Enemigo crearEnemigo () {
		Random r = new Random();
		int velocidad = 5 + r.nextInt(10);
		return new Enemigo1(mapa.getCelda(r.nextInt(5), 9));
	}
	
=======
>>>>>>> c97a0f3bd529248bad62fe74a1c300753fd99822
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
