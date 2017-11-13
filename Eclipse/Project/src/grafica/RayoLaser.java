package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;

public class RayoLaser extends GraficoDisparo {


Juego j = Juego.getJuego();
JLabel panelMapa = j.getInterfaz().getPanelMapa();
JLabel grafico;
ImageIcon image;

Point izq = new Point((int)a.getX()+ Constantes.width,(int)a.getY()+ Constantes.height/2-altoDisparo/2);	//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
Point der = new Point((int)b.getX(), (int)b.getY()+ Constantes.height/2-altoDisparo/2 );				//a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente

image = new ImageIcon(Constantes.path+"dispIzq.png"); 


Image imagen = image.getImage(); 
Image newimg = imagen.getScaledInstance((int)( der.getX()-izq.getX() + 1 ), altoDisparo,  java.awt.Image.SCALE_DEFAULT); 
image = new ImageIcon(newimg);
grafico = new JLabel(image);
grafico.setBounds((int)izq.getX(), (int)izq.getY(), (int)( der.getX()-izq.getX() ), altoDisparo+10);
grafico.setVisible(true);
panelMapa.add(grafico);
grafico.repaint();

grafico.setVisible(false);
//grafico.repaint();

panelMapa.remove(grafico);
}
