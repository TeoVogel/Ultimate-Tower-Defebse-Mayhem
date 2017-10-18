package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Aliado;

public class GraficoAliado extends Grafico{
	private Aliado aliado;
	
	public GraficoAliado (Aliado a, String name) {
		super(a, name);
		aliado = a;

		this.image = new Icon[3];
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[1] + ".gif"); //en movimiento
		this.image[2] = new ImageIcon(path + archivos[2] + ".gif"); //ni idea
		//this.image[2] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //atacando
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //muriendo
	
	}

}
