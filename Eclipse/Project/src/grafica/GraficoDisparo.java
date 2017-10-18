package grafica;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;

public class GraficoDisparo{
	protected static int altoDisparo=10;
	
	public static void crearDisparo(Grafico a, Grafico b, String dir){
		JLabel grafico;
		ImageIcon image;
		Point izq=new Point((int)a.getPos().getX()+ Grafico.width,(int)a.getPos().getY()+ Grafico.height/2-altoDisparo/2);//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
		Point der=new Point((int)b.getPos().getX(), (int)b.getPos().getY()+ Grafico.height/2-altoDisparo/2 );							  //a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente
		if(dir=="der") {
			image = new ImageIcon("assets/dispDer.gif"); 
		}else if(dir=="izq"){
			image = new ImageIcon("assets/dispIzq.gif"); 
		}else return;
		Image imagen = image.getImage(); // transform it 
		Image newimg = imagen.getScaledInstance(100, altoDisparo,  java.awt.Image.SCALE_DEFAULT); // scale it the smooth way
		image = new ImageIcon(newimg);
		grafico=new JLabel(image);
		grafico.setBounds((int)izq.getX(),(int)izq.getY(), (int)( der.getX()-izq.getX() ), altoDisparo);
		grafico.setVisible(true);
	}
	
}
