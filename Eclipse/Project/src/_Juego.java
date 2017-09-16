

import java.util.LinkedList;
//import java.util.Random;

import javax.swing.JOptionPane;

public class _Juego {
	
	private _GUI gui;
	private ContadorTiempo tiempo;
	public LinkedList<Malo> secuenciaEnemigos; //Modificar mas adelante
	//private Celda[][] grilla;
	
	public _Juego() {
		gui = new _GUI();
		gui.setVisible(true);
		secuenciaEnemigos = new LinkedList<Malo>();
		//tiempo = new ContadorTiempo(this);
		//tiempo.start();
		
		Malo m = new Malo(10, 100, 100);
		secuenciaEnemigos.add(m);
		gui.add(m.getGrafico());
	}
	
	public void mover(){
		for(Malo e : secuenciaEnemigos){
			e.mover(2);
		}
	}
	
	public static void main(String[] args) {
		_Juego juego = new _Juego();
	}

}