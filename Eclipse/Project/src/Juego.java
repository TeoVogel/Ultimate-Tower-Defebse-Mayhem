package tmp;

import java.awt.event.KeyEvent;
import java.util.Random;


public class Juego {
	
	private Enemigo enemigos[];

	private GUI gui;
	private ContadorTiempo tiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	public Juego(){
		gui = new GUI();
		
		enemigos = new Enemigo[5];		
		
		for(int i = 0; i < enemigos.length; i++){
			Random r = new Random();
			int velocidad = 5 + r.nextInt(10);
			int offset = r.nextInt(100);
			int fila = r.nextInt(5);
			enemigos[i] = new Enemigo(velocidad, gui.getWidth() + offset, fila*100);
			gui.add(enemigos[i].getGrafico());
		}
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	public void mover(){
		for(int i = 0; i < enemigos.length; i++)			
			enemigos[i].mover(2);
	}
	
	public void mover(int dir){		
		int direccion = 0;
		
		switch (dir){
			case KeyEvent.VK_UP : //Arriba
				direccion = 0;
				break;
			case KeyEvent.VK_DOWN : //Abajo
				direccion = 1;
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 2;
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 3;
				break;
		}
		
		//jugador.mover(direccion);
	}

}
