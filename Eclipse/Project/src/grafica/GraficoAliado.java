package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.Constantes;
import juego.ente.Aliado;

public class GraficoAliado extends Grafico {
	// sufijosArchivos ["_parar", "_morir", "_frente", "_atacar", "_mover"]
	// sufijosArchivos [  0  |  1  |   2  |   3  |  4  ]
	// sufijosArchivos [parar|morir|frente|atacar|mover]
	
	private Aliado aliado;
	
	public GraficoAliado (Aliado a, String name) {
		super(a, name);
		aliado = a;

<<<<<<< HEAD
		this.image = new Icon[3];
		this.image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif"); //en movimiento
		this.image[2] = new ImageIcon(Constantes.path + name + sufijosArchivos[2] + ".gif"); //ni idea
		//this.image[2] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //atacando
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //muriendo
=======
		this.image = new Icon[2];
		this.image[0] = new ImageIcon(path + name + sufijosArchivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + name + sufijosArchivos[4] + ".gif"); //en movimiento
>>>>>>> 8744c7af412b8e9064e01053f692a304f4495cca
	
	}

}
