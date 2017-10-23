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

	int dificultad;
	ArrayList<Enemigo> enemigos;
	Random random;
	
	public Nivel (int d) {
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
		
		while (enemigos.size() > 0) {
			try {
				Celda celda = mapa.getCelda(random.nextInt(6), 8 + random.nextInt(2));
				enemigos.get(0).init(celda);
				mapa.addEnemigo(enemigos.remove(0));			
				sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
