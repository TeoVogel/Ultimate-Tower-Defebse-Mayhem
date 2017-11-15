package grafica;

import javax.swing.ImageIcon;
import juego.Constantes;

public class RayoLaserAliado extends GraficoDisparo {
	
	public RayoLaserAliado(){
		super();
		disparo = new ImageIcon(Constantes.path+"atacks/disp_aliado.png");
		corrimiento = 10;
	}	
}
