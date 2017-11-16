package grafica;

import javax.swing.ImageIcon;

import juego.Constantes;

public class RayoLaserEnemigo  extends GraficoDisparo {
	
	public RayoLaserEnemigo() {
		super();
		disparo = new ImageIcon(Constantes.path+"atacks/disp_enemigo.png");
		corrimiento = -10;
	}
	
}
