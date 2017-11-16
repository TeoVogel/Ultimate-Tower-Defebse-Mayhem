package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;

public abstract class GraficoDisparo implements Grafico {
	protected int altoDisparo = 10;
	protected int corrimiento;
	
	protected ImageIcon disparo;
	protected JLabel grafico;
	
	public GraficoDisparo() {}
	
	public void action() {
		grafico.setVisible(false);
		grafico.repaint();
		grafico.getParent().remove(grafico);
	}
	
	public void graficar(GraficoEnte ataca, GraficoEnte recibe){
		int largo;
		
		int X = ataca.getX() + Constantes.width; 										// la derecha del atacante
		int Y = ataca.getY() + Constantes.height/2 - altoDisparo/2 + corrimiento;		//y = centra el disparo en el medio del atacante
		Point izq = new Point( X , Y);													// [a]- izq es donde el guion toca al corchete (a= atacar)
		
		X = recibe.getX();									 							//la izquierda del que recibe
		Y = recibe.getY()+ Constantes.height/2 - altoDisparo/2 + corrimiento;			// centra el disparo en el medio del qe recibe	
		Point der = new Point(X, Y);						  							// -[r] der es donde el guion toca al corchete (r= recibir)
		
		largo=(int) (der.getX()-izq.getX() + 1);// largo del disparo= distancia desde izq hasta der
		
		Image imagenAlargada = disparo.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance( largo, altoDisparo,  java.awt.Image.SCALE_DEFAULT);
		
		disparo = new ImageIcon(imagenAlargada);
		grafico = new JLabel(disparo);
		
		grafico.setBounds((int)izq.getX(), (int)izq.getY(), largo, altoDisparo );
		grafico.setVisible(true);
		Juego.getJuego().getInterfaz().getPanelMapa().add(grafico);
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 3);
		grafico.repaint();
	}
}
