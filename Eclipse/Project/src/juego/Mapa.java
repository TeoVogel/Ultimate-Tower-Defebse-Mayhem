package juego;

import java.util.ArrayList;
import java.util.List;

import grafica.PanelMapa;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Obstaculo;

public class Mapa{

	
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	private List<Aliado> aliados;
	private PanelMapa panelMapa;
	
	public Mapa (PanelMapa p) {
		enemigos = new ArrayList<Enemigo>();
		aliados = new ArrayList<Aliado>();
		panelMapa = p;
		inicializarGrilla();
	}
	
	
	// Crea grilla y setea todas las celdas con anterior y siguiente
	protected void inicializarGrilla() {
		grilla = new Celda[6][10];
		
		// Inicializa todas las celdas de la grilla
		for (int i = 0; i < 6; i++)
			for (int ii = 0; ii < 10; ii++)
				grilla[i][ii] = new Celda(i, ii);
		
		// Setea la celda derecha de la primer columna y la izquierda de la la ultima
		for (int i = 0; i < 6; i++) {
			grilla[i][0].setDer(grilla[i][1]);
			grilla[i][9].setIzq(grilla[i][8]);
		}	
		 
		// Setea izquierda y derecha de las celdas restantes
		for (int i = 0; i < 6; i++)
			for (int j = 1; j < 9; j++) {
				grilla[i][j].setDer(grilla[i][j+1]);
				grilla[i][j].setIzq(grilla[i][j-1]);
			}
		
		// Setea la celda de arriba de la ultima fila y la de abajo de la primera
		for (int i = 0; i < 10; i++) {
			grilla[6][i].setArriba(grilla[5][i]);
			grilla[0][i].setAbajo(grilla[1][i]);
		}
		
		// Setea arriba y abajo de las celdas restantes
		for (int i = 1; i < 5; i++)
			for (int j = 0; j < 10; j++) {
				grilla[i][j].setArriba(grilla[i-1][j]);
				grilla[i][j].setAbajo(grilla[i+1][j]);
			}
	}
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e, int fila, int columna) {
		enemigos.add(e);
		panelMapa.addEnte(e);
		e.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addEnemigo (Enemigo e) {
		enemigos.add(e);
		panelMapa.addEnte(e);
	}

	public void addAliado (Aliado a, int fila, int columna) {
		aliados.add(a);
		panelMapa.addEnte(a);
		a.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addAliado (Aliado a) {
		aliados.add(a);
		panelMapa.addEnte(a);
	}

	public void addObstaculo (Obstaculo o, int fila, int columna) {
		panelMapa.addEnte(o);
		o.init(grilla[fila][columna]);
	}
	
	@Deprecated
	public void addObstaculo (Obstaculo o) {
		panelMapa.addEnte(o);
	}
	
	public void mover() {
		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) {
				//juego.sumarPuntos(e.getPuntos());
				enemigosMuertos.add(i);
			}
			e.mover();
		}
		/*for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
			System.out.println("Removido");
		}*/
	}
	
	public void atacar () {
		List<Integer> aliadosMuertos = new ArrayList<Integer>();
		for (int i=0; i<aliados.size(); i++) {
			Aliado a = aliados.get(i);
			if (a.getVida() <= 0) 
				aliadosMuertos.add(i);
			else 
				a.atacar();
		}
		for (Integer i : aliadosMuertos) {
			aliados.remove((int) i);
		}

		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) 
				enemigosMuertos.add(i);
			else
				e.atacar();
		}
		for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
		}
	}
	
	
	// TODO: elimnar esto, es solo para testear
	public Celda getCelda(int f, int c) {
		return grilla[f][c];
	}
	
}