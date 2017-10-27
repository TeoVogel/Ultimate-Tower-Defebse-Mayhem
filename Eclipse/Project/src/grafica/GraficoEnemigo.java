package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.EstadoEnteMover;
import juego.ente.EstadoEnteParar;
import juego.Constantes;

public class GraficoEnemigo extends Grafico {
	// sufijosArchivos ["_parar", "_morir", "_frente", "_atacar", "_mover"]
	// sufijosArchivos [  0  |  1  |   2  |   3  |  4  ]
	// sufijosArchivos [parar|morir|frente|atacar|mover]
	
	private float acumuladorPixeles;
	
	public GraficoEnemigo (Enemigo e, String name) {
		super(e, name);

		this.image = new Icon[4];
		this.image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[4] + ".gif"); //en movimientos
	}
	
	
	public void mover() {
		Enemigo enemigo = (Enemigo) ente;
		
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null) {
			Ente enteIzq = izq.getEnte();
			if (enteIzq == null || enteIzq.getEstado().enMovimiento()) {
				int velocidad = enemigo.getVelocidad();
				
				float delta = 100f / velocidad;
				System.out.println(""+delta);
				int pixeles = (int) delta;
				acumuladorPixeles += delta - pixeles;
				
				pixeles += acumuladorPixeles;
				acumuladorPixeles -= (int) acumuladorPixeles;
				
				System.out.println("" + acumuladorPixeles + ", " + delta + ", " + velocidad + ", " + pixeles);
				
				pos.setLocation(pos.x - pixeles, pos.y);
				ente.setEstado(new EstadoEnteMover()); // TODO: clase estática
				cambiarGrafico(1);
				return;
			}
		}

		ente.setEstado(new EstadoEnteParar());
		cambiarGrafico(0);
	}
	
}