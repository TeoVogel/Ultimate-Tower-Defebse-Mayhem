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
import juego.ente.powerup.FactoryPowerUps;
import juego.ente.powerup.PowerUp;

public abstract class Nivel extends Thread {

	protected Mapa mapa;
	protected int dificultad;
	protected ArrayList<Enemigo> enemigos;
	private Random random;
	
	private final int NUM_TANDAS = 3;
	private final int PAUSA_ENTRE_TANDAS = 3000; //en milis
	
	public Nivel (Mapa m, int d) {
		mapa = m;
		dificultad = d;
		System.out.println("Nuevo nivel con dificultad: "+dificultad);
		
		random = new Random();
	}
	
	
	public abstract void init ();
	
	private ArrayList<Enemigo> crearListaEnemigos () {
		ArrayList<Enemigo> lista = new ArrayList<Enemigo>();		
		
		int size = calcularCantEnemigos();
		for (int i = 0; i < size; i++) {
			Enemigo e = FactoryEnemigo.crearEnemigo(calcularTipoEnemigo());
			e.setPowerUp(calcularPowerUpRandom());
			lista.add(e);
			System.out.println("Creando " + size + " enemigos");
		}
		
		return lista;
	}
	
	private int calcularCantEnemigos () {
		return 5 * 2^dificultad;
	}
	
	private String calcularTipoEnemigo () {
		int cantTipos = Constantes.enemigos.length;
		Random random = new Random();
		
		int tipo = random.nextInt(dificultad)%cantTipos;
		
		return Constantes.enemigos[tipo];
	}
	
	private PowerUp calcularPowerUpRandom () {
		int tipo = random.nextInt(10);
		return FactoryPowerUps.getPowerUp(tipo);		
	}
	
	
	public void run () {
		Mapa mapa = Juego.getJuego().getMapa();

		try {
			
			int tandaActual = 0;
			while (tandaActual < NUM_TANDAS) {
				
			
				sleep(PAUSA_ENTRE_TANDAS);
				enemigos = crearListaEnemigos();
				
				/** spawnear enemigos **/
				
				int i = 0;
				while (i < enemigos.size()) {
					int fila = random.nextInt(6);
					int columna = 8 + random.nextInt(2);
					boolean insertado = mapa.addEnemigo(enemigos.get(i), fila, columna);
					if (insertado) {
						i++;
					}
					System.out.println("Spawneando enemigo, quedan " + enemigos.size() + ". Mi contador es " + i);
					sleep(2000);
				}
				
				/** controlar cuando el nivel fue completado **/
				
				List<Enemigo> muertos = new ArrayList<Enemigo>();			
				while (enemigos.size() > 0) {
					i = 0;
					while (i < enemigos.size()) {
						if (enemigos.get(i).getVida() <= 0) {
							muertos.add(enemigos.get(i));
						}
						i++;
					}
					
					for (Enemigo e : muertos) {
						enemigos.remove(e);
						System.out.println("Enemigo muerto, quedan " + enemigos.size());
					}
					sleep(3000);
				}
				
				tandaActual++;
				
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Nivel terminado, siguiente!");
		Juego.getJuego().siguienteNivel();
	}
	
}
