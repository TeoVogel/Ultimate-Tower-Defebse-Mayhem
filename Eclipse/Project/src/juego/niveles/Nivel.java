package juego.niveles;

import java.util.ArrayList;
import java.util.Random;

import juego.Constantes;
import juego.FactoryEnemigo;
import juego.Juego;
import juego.Mapa;
import juego.ente.Celda;
import juego.ente.Enemigo;

public abstract class Nivel extends Thread {

	protected Mapa mapa;
	protected int dificultad;
	protected ArrayList<Enemigo> enemigos;
	private Random random;
	
	public Nivel (Mapa m, int d) {
		mapa = m;
		dificultad = d;
		System.out.println(""+dificultad);
		
		random = new Random();
		
		int size = calcularCantEnemigos();
		enemigos = new ArrayList<Enemigo>();
		for (int i = 0; i < size; i++) {
			enemigos.add(FactoryEnemigo.crearEnemigo(calcularTipoEnemigo()));
			System.out.println(""+size);
		}
		
	}
	
	public abstract void init ();
	
	public int calcularCantEnemigos () {
		return 10 * 2^dificultad;
	}
	
	public String calcularTipoEnemigo () {
		int cantTipos = Constantes.enemigos.length;
		Random random = new Random();
		
		int tipo = random.nextInt(dificultad)%cantTipos;
		
		return Constantes.enemigos[tipo];
	}
	
	public void run () {
		Mapa mapa = Juego.getJuego().getMapa();

		try {
			
			int i = 0;
			while (i < enemigos.size()) {
				Celda celda = mapa.getCelda(random.nextInt(6), 8 + random.nextInt(2));
				enemigos.get(i).init(celda);
				mapa.addEnemigo(enemigos.get(i++));			
				sleep(2000);
			}
			
			while (enemigos.size() > 0) {
				i = 0;
				while (i < enemigos.size()) {
					if (enemigos.get(i).getVida() <= 0) {
						enemigos.remove(i);
					}
				}
				sleep(2000);
			}
			
			Juego.getJuego().siguienteNivel();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
