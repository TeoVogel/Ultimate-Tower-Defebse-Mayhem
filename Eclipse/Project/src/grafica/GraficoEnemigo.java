package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.Constantes;

public class GraficoEnemigo extends Grafico {
	// sufijosArchivos ["_parar", "_morir", "_frente", "_atacar", "_mover"]
	// sufijosArchivos [  0  |  1  |   2  |   3  |  4  ]
	// sufijosArchivos [parar|morir|frente|atacar|mover]
	
	public GraficoEnemigo (Enemigo e, String name) {
		super(e, name);

		this.image = new Icon[4];
<<<<<<< HEAD
		this.image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[4] + ".gif"); //en movimientos
=======
		this.image[0] = new ImageIcon(path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + name + sufijosArchivos[4] + ".gif"); //en movimiento
>>>>>>> 8744c7af412b8e9064e01053f692a304f4495cca
	
	}
	
	
	public void mover() {
		Enemigo enemigo = (Enemigo) ente;
		
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null && izq.getEnte() == null) {
			int velocidad = enemigo.getVelocidad();
			int delta = 100 / velocidad;
			pos.setLocation(pos.x - delta, pos.y);
			cambiarGrafico(1);
//			System.out.println("__Moviendose");
		} else {
			cambiarGrafico(0);
//			System.out.println("__Parado");
		}
	}
	
}