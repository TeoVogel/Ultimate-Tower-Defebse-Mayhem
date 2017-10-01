import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;


public class Juego {

	private Mapa mapa;
	private ContadorTiempo tiempo;
	
	private Mercado mercado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	public Juego(){
		mapa = new Mapa(this);
		createMarket();
		
		for(int i = 0; i < 5; i++)
			mapa.addEnemigoRandom(crearEnemigoRandom());
		
		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}
	
	public void mover(){		
		for (Enemigo e : mapa.getEnemigos())
			e.mover();
	}
	
	private void createMarket () {
		mercado = new Mercado();
		
		JButton button = new JButton("Spaw enemy");
		button.setLocation(0,0);
		button.setBounds(0, 0, 100, 50);
		mapa.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mercado.addToPlaceHolder(new SpawnearEnemigo(crearEnemigo(), getThis()));
			}			
		});
	}
	
	public Mercado getMercado () {
		return mercado;
	}
	
	public Mapa getMapa () {
		return mapa;
	}
	
	public Juego getThis() { return this; }
	
	private Enemigo crearEnemigoRandom () {
		Random r = new Random();
		int velocidad = 5 + r.nextInt(10);
		int offset = r.nextInt(100);
		int fila = r.nextInt(5);
		return new Enemigo(velocidad, mapa.getWidth() + offset, fila*100);
	}
	
	private Enemigo crearEnemigo () {
		Random r = new Random();
		int velocidad = 5 + r.nextInt(10);
		return new Enemigo(velocidad, 0, 0);
	}

}
