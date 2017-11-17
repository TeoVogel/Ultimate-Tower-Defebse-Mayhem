package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Juego;

public class RayoLaserAliado extends GraficoDisparo {
	
	public RayoLaserAliado() {
		super();
		disparo = new ImageIcon(Interfaz.path+"atacks/disp_aliado.png");
		corrimiento = 10;
	}	
	
	public void graficar(GraficoEnte ataca, GraficoEnte recibe){
		int largo;
		
		int X = ataca.getX() + PanelMapa.TILE_WIDTH; 									// la derecha del atacante
		int Y = ataca.getY() + PanelMapa.TILE_HIGHT/2 - altoDisparo/2 + corrimiento;	//y = centra el disparo en el medio del atacante
		Point izq = new Point( X , Y);													// [a]- izq es donde el guion toca al corchete (a= atacar)
		
		X = recibe.getX();									 							//la izquierda del que recibe
		Y = recibe.getY()+ PanelMapa.TILE_HIGHT/2 - altoDisparo/2 + corrimiento;		// centra el disparo en el medio del qe recibe	
		Point der = new Point(X, Y);						  							// -[r] der es donde el guion toca al corchete (r= recibir)
		
		largo = (int) (der.getX() - izq.getX() + 1);			// largo del disparo = distancia desde izq hasta der
		
		Image imagenAlargada = disparo.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance(largo, altoDisparo, java.awt.Image.SCALE_DEFAULT);
		
		disparo = new ImageIcon(imagenAlargada);
		grafico = new JLabel(disparo);
		
		grafico.setBounds((int)izq.getX(), (int)izq.getY(), largo, altoDisparo);
		grafico.setVisible(true);
		Juego.getJuego().getInterfaz().getPanelMapa().add(grafico);
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 3);
		grafico.repaint();
	}
	
}
