package juego;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import grafica.Interfaz;

public class Mapa extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	
	private Interfaz interfaz;
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	private List<Aliado> aliados;
	
	public Mapa (Juego j, Interfaz interfaz) {
		enemigos = new ArrayList<Enemigo>();
		aliados = new ArrayList<Aliado>();
		juego = j;
		
		// Crea grilla y setea todas las celdas con anterior y siguiente
		grilla = new Celda[6][10];
		for (int i = 0; i < 6; i++)
			for (int ii = 0; ii < 10; ii++)
				grilla[i][ii] = new Celda(i, ii);
		
		for (int i = 0; i < 6; i++)
			grilla[i][0].setDer(grilla[i][1]);
		
		for (int i = 0; i < 6; i++)
			grilla[i][5].setIzq(grilla[i][4]);
			
		for (int i = 0; i < 6; i++)
			for (int ii = 1; ii < 9; ii++) {
				grilla[i][ii].setDer(grilla[i][ii+1]);
				grilla[i][ii].setIzq(grilla[i][ii-1]);
			}
			
		this.interfaz= interfaz;
	}
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e) {
		enemigos.add(e);
		interfaz.addGrafico(e.getGrafico());
	}
	
	public void addAliado (Aliado a, int fila, int columna) {
		aliados.add(a);
		interfaz.addGrafico(a.getGrafico());
	}

	public void mover(){
		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (Enemigo e : enemigos)
			e.mover();
		for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
			System.out.println("Removido");
		}
		System.out.println(enemigos.size() + "      " + juego.getPuntos());
	}

	
	// TODO: elimnar esto, es solo para testear
	public Celda getCelda(int f, int c) {
		return grilla[f][c];
	}
	
}
