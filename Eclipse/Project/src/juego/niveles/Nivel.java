package juego.niveles;

import java.util.ArrayList;
import java.util.List;
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
		System.out.println("Nuevo nivel con dificultad: "+dificultad);
		
		random = new Random();
		
		int size = calcularCantEnemigos();
		enemigos = new ArrayList<Enemigo>();
		for (int i = 0; i < size; i++) {
			enemigos.add(FactoryEnemigo.crearEnemigo(calcularTipoEnemigo()));
			System.out.println("Creando " + size + " enemigos");
		}
		
	}
	
	public abstract void init ();
	
	public int calcularCantEnemigos () {
		return 1 * 2^dificultad;
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
			sleep(3000);
			
			// spawnear enemigos
			int i = 0;
			while (i < enemigos.size()) {
				int fila = random.nextInt(6);
				int columna = 8 + random.nextInt(2);
				mapa.addEnemigo(enemigos.get(i++), fila, columna);
				System.out.println("Spawneando enemigo, quedan " + enemigos.size() + ". Mi contador es " + i);
				sleep(2000);
			}
			
			System.out.println("No hay más que spawnear");
			
			// controlar cuando el nivel fue completado
			List<Enemigo> muertos = new ArrayList<Enemigo>();			
			while (enemigos.size() > 0) {
				System.out.println("Hola?");
				i = 0;
				while (i < enemigos.size()) {
					System.out.println("Hola2?");
					if (enemigos.get(i).getVida() <= 0) {
						muertos.add(enemigos.get(i));
					}
					i++;
				}
				System.out.println("Hola3?");
				
				for (Enemigo e : muertos) {
					enemigos.remove(e);
					System.out.println("Enemigo muerto, quedan " + enemigos.size());
				}
				sleep(3000);
			}

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Nivel terminado, siguiente!");
		Juego.getJuego().siguienteNivel();
	}
	
}
