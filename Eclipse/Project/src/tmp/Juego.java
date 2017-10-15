package tmp;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

import logica.acciones.AccionSpawnearAliado;
import logica.acciones.AccionSpawnearEnemigo;


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
		
		for(int i = 0; i < 5; i++) {
			Random r = new Random();
			int columnaOffset = r.nextInt(3);
			int fila = r.nextInt(5);
			mapa.addEnemigo(crearEnemigo(), fila, 10 + columnaOffset);
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
				mercado.addToPlaceHolder(new AccionSpawnearEnemigo(crearEnemigo(), getThis()));
			}			
		});
		
		JButton buttonA = new JButton("SpawA");
		buttonA.setBounds(0, 0, 100, 50);
		mapa.add(buttonA);
		buttonA.setLocation(100,0);
		buttonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mercado.addToPlaceHolder(new AccionSpawnearAliado(crearAliado(), getThis()));
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
	

	private Enemigo crearEnemigo () {
		Random r = new Random();
		int velocidad = 5 + r.nextInt(10);
		return new Enemigo(velocidad, 0, 0);
	}
	
	private Aliado crearAliado () {
		Random r = new Random();
		return new Aliado(0, 0, 0);
	}
	
	//TODO esto es horrible
	public Juego getThis() { return this; }

}
