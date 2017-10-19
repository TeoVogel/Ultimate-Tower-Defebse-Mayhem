package grafica;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import juego.Juego;
import juego.Constantes;
public class GraficoDisparo extends Thread{
	protected static int altoDisparo=10;
	
	public static void crearDisparo(JLabel a, JLabel b, String dir){
		Juego j=Juego.getJuego();
		JFrame frame=j.getInterfaz();
		JLabel grafico;
		ImageIcon image;
<<<<<<< HEAD
		Point izq = new Point((int)a.getX()+ Constantes.width,(int)a.getY()+ Constantes.height/2-altoDisparo/2);	//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
		Point der = new Point((int)b.getX(), (int)b.getY()+ Constantes.height/2-altoDisparo/2 );				//a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente
		
=======
		Point izq = new Point((int)a.getX()+ Grafico.width,(int)a.getY()+ Grafico.height/2-altoDisparo/2);	//a la derecha y a la mitad(+la mitad de la altura del disparo) del ente
		Point der = new Point((int)b.getX(), (int)b.getY()+ Grafico.height/2-altoDisparo/2 );				//a la izquierda y a la mitad(+la mitad de la altura del disparo) del ente
>>>>>>> 3d916a27893074fe987e819afb6e96b3839efe76
		
		image = new ImageIcon(Constantes.path+"assets/dispIzq.png"); 
		/*if(dir=="der")
			image = new ImageIcon(Constantes.path+"assets/dispDer.gif"); 
		else
			if(dir=="izq")
				image = new ImageIcon(Constantes.path+"assets/dispIzq.gif"); 
			else
				return;
		*/
		Image imagen = image.getImage(); // transform it 
		Image newimg = imagen.getScaledInstance(100, altoDisparo,  java.awt.Image.SCALE_DEFAULT); // scale it the smooth way
		image = new ImageIcon(newimg);
		grafico = new JLabel(image);
		grafico.setBounds((int)izq.getX(),(int)izq.getY(), (int)( der.getX()-izq.getX() ), altoDisparo);
		
		frame.add(grafico);
		grafico.setVisible(true);
		grafico.repaint();
		try {
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.remove(grafico);
	}
	
}
