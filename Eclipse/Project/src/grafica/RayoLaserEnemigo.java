package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;

public class RayoLaserEnemigo  extends GraficoDisparo {
	
	public RayoLaserEnemigo() {
		super();
		disparo = new ImageIcon(Constantes.path+"atacks/disp_enemigo.png");
		corrimiento = -10;
	}
	
	public void graficar(GraficoEnte recibe, GraficoEnte ataca){
		int largo;
		
		int X = recibe.getX() + PanelMapa.TILE_WIDTH; 									// la derecha del que recibe
		int Y = recibe.getY() + PanelMapa.TILE_HIGHT/2 - altoDisparo/2 + corrimiento;	//y = centra el disparo en el medio del recibe
		Point izq = new Point( X , Y);													// [a]- izq es donde el guion toca al corchete (a= atacar)
		
		X = ataca.getX();									 							//la izquierda del que ataca
		Y = ataca.getY()+ PanelMapa.TILE_HIGHT/2 - altoDisparo/2 + corrimiento;			// centra el disparo en el medio del qe ataca	
		Point der = new Point(X, Y);						  							// -[r] der es donde el guion toca al corchete (r= recibir)
		
		largo = (int) (der.getX() - izq.getX() + 1);			// largo del disparo = distancia desde izq hasta der
		
		Image imagenAlargada = disparo.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance(largo, altoDisparo, java.awt.Image.SCALE_DEFAULT);
		
		disparo = new ImageIcon(imagenAlargada);
		grafico = new JLabel(disparo);
		
		grafico.setBounds((int)der.getX()-largo, (int)der.getY(), largo, altoDisparo); //se utilizan los parametros del atacante
		grafico.setVisible(true);
		Juego.getJuego().getInterfaz().getPanelMapa().add(grafico);
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 3);
		grafico.repaint();
	}	
}
