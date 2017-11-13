package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import grafica.GraficoEnte;

public class RayoLaserAliado extends GraficoDisparo {
	protected ImageIcon disp = new ImageIcon(Constantes.path+"atacks/disparo_aliado.png");
	JLabel grafico;
	
	
	public void graficar(GraficoEnte atacar, GraficoEnte recibir) {
		Point izq = new Point((int)atacar.getX() + Constantes.width,(int)atacar.getY() + Constantes.height/2-altoDisparo/2);	//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
		Point der = new Point((int)recibir.getX(), (int)recibir.getY()+ Constantes.height/2-altoDisparo/2 );				//a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente

		Image imagenAlargada = disp.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance((int)( der.getX()-izq.getX() + 1 ), altoDisparo,  java.awt.Image.SCALE_DEFAULT); 
		disp = new ImageIcon(imagenAlargada);
		grafico = new JLabel(disp);
		grafico.setBounds((int)izq.getX(), (int)izq.getY(), (int)( der.getX()-izq.getX() ), altoDisparo+10);
		grafico.setVisible(true);
		Juego.getJuego().getInterfaz().getPanelMapa().add(grafico);
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(grafico, 5);
	}	
}
