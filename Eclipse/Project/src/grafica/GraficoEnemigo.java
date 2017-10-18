package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Celda;
import juego.ente.Enemigo;



public class GraficoEnemigo extends Grafico {
	// archivos [name+"_parar", name+"_morir", name+"_frente", name+"_atacar", name+"_mover"]
	// archivos [  0  |  1  |   2  |   3  |  4  ]
	// archivos [parar|morir|frente|atacar|mover]
	private Enemigo enemigo;
	
	public GraficoEnemigo (Enemigo e, String name) {
		super(e, name);
		
		enemigo = e;

		this.image = new Icon[4];
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[4] + ".gif"); //en movimiento
	
		initGrafico(enemigo);
	}
	
	
	public void mover() {
		
		Celda izq = enemigo.getCelda().getIzq();
		/*
		String tmp1 = "izq != null", tmp2 = "	ente = null";
		if (izq == null)
			tmp1 = "izq = null";
		else
			if (izq.getEnte() != null)
				tmp2 = "ente != null";
				
		System.out.println(tmp1+tmp2+'\n');
		*/
		
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