

import java.util.LinkedList;
//import java.util.Random;
import java.util.Random;

import javax.swing.JOptionPane;

import juego.Enemigo;

public class _Juego {
	
	private _GUI gui;
	private ContadorTiempo tiempo;
	public LinkedList<Enemigo> secuenciaEnemigos; //Modificar mas adelante
	//private Celda[][] grilla;
	
	public _Juego() {
		gui = new _GUI();
		gui.setVisible(true);
		secuenciaEnemigos = new LinkedList<Enemigo>();
		//tiempo = new ContadorTiempo(this);
		//tiempo.start();
		
		Enemigo m = new Enemigo(10, 100, 100);
		secuenciaEnemigos.add(m);
		gui.add(m.getGrafico());
		
	}
	
	public void mover(){
		for(Enemigo e : secuenciaEnemigos){
			e.mover(2);
		}
	}
	
	public static void main(String[] args) {
		_Juego juego = new _Juego();
	}

}