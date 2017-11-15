package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import grafica.GraficoEnte;

public class RayoLaserAliado extends GraficoDisparo {
	protected ImageIcon disparo = new ImageIcon(Constantes.path+"atacks/disparo_aliado.png");
	JLabel grafico;
	
	
	public void graficar(GraficoEnte atacar, GraficoEnte recibir) {
		int largo;
		
		int X = atacar.getX() + Constantes.width; 					// la derecha del atacante
		int Y = atacar.getY() + Constantes.height/2 - altoDisparo/2;//y = centra el disparo en el medio del atacante
		Point izq = new Point( X , Y);								// [a]- izq es donde el guion toca al corchete (a= atacar)
		
		X = recibir.getX();									  //la izquierda del que recibe
		Y = recibir.getY()+ Constantes.height/2-altoDisparo/2;// centra el disparo en el medio del qe recibe	
		Point der = new Point( X , Y );						  // -[r] der es donde el guion toca al corchete (r= recibir)
		
		largo=(int) (der.getX()-izq.getX() + 1);// largo del disparo= distancia desde izq hasta der
		
		Image imagenAlargada = disparo.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance( largo, altoDisparo,  java.awt.Image.SCALE_DEFAULT);
		
		disparo = new ImageIcon(imagenAlargada);
		grafico = new JLabel(disparo);
		
		grafico.setBounds( (int)izq.getX(), (int)izq.getY(), largo, altoDisparo );
		grafico.setVisible(true);
		panelMapa.add(grafico);
		panelMapa.graficoTemporal(grafico, 5);
	}	
}
