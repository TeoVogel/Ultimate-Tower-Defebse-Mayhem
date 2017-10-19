package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Aliado;

public class GraficoAliado extends Grafico {
	// sufijosArchivos ["_parar", "_morir", "_frente", "_atacar", "_mover"]
	// sufijosArchivos [  0  |  1  |   2  |   3  |  4  ]
	// sufijosArchivos [parar|morir|frente|atacar|mover]
	
	private Aliado aliado;
	
	public GraficoAliado (Aliado a, String name) {
		super(a, name);
		aliado = a;

		this.image = new Icon[2];
		this.image[0] = new ImageIcon(path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + name + sufijosArchivos[4] + ".gif"); //en movimiento
	
	}

}
