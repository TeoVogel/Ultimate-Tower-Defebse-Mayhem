

import java.util.LinkedList;
//import java.util.Random;

import gui.ContadorTiempo;
import gui.Enemigo;
import gui._GUI;


public class _Juego {
	
	private static _GUI gui;
	private ContadorTiempo tiempo;
	public static LinkedList<Enemigo> secuenciaEnemigos; //Modificar mas adelante
	//private Celda[][] grilla;
	
	public _Juego() {
		gui = new _GUI();
		gui.setVisible(true);
		secuenciaEnemigos = new LinkedList<Enemigo>();
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	public void mover(){
		for(Enemigo e : secuenciaEnemigos){
			e.mover(2);
		}
	}
	
	public static void main(String[] args) {
		_Juego juego = new _Juego();
		Enemigo m = new Enemigo(10, 950, 300);
		secuenciaEnemigos.add(m);
		gui.add(m.getGrafico());
	}

}