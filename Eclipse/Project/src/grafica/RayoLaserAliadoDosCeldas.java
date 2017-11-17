package grafica;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Juego;

public class RayoLaserAliadoDosCeldas extends RayoLaserAliado {
	
	protected JLabel graficoBajo;
	boolean disparaAbajo;
	
	public RayoLaserAliadoDosCeldas() {
		super();	
	}
	
	@Override
	public void action() {
		if(graficoBajo == null){		//si solo se disparo arriba
			grafico.setVisible(false);
			grafico.repaint();
			Juego.getJuego().getInterfaz().getPanelMapa().remove(grafico);
			grafico= null;
		}else if(grafico == null) {		//si solo se disparo abajo
			graficoBajo.setVisible(false);
			graficoBajo.repaint();
			Juego.getJuego().getInterfaz().getPanelMapa().remove(graficoBajo);
			graficoBajo= null;
		}else{							//si se dispararon los dos
			grafico.setVisible(false);
			grafico.repaint();
			Juego.getJuego().getInterfaz().getPanelMapa().remove(grafico);
			grafico= null;
			
			graficoBajo.setVisible(false);
			graficoBajo.repaint();
			Juego.getJuego().getInterfaz().getPanelMapa().remove(graficoBajo);
			graficoBajo= null;
		}		
	}
	
	@Override
	public void graficar(GraficoEnte ataca, GraficoEnte recibe){
		int largo;
		int hight= PanelMapa.TILE_HIGHT;
		int width= PanelMapa.TILE_WIDTH;
		
		int X = recibe.getX();									 						//la izquierda del que recibe
		int Y = recibe.getY()+ hight/2 - altoDisparo + corrimiento;						// centra el disparo en el medio del qe recibe	
		Point der = new Point(X, Y);						  							// -[r] der es donde el guion toca al corchete (r= recibir)
		
		X = ataca.getX() + width;														// la derecha del atacante
		if( der.getY() < ataca.getY() + hight ) {
			Y = ataca.getY() + hight/2 - altoDisparo + corrimiento;						//y = centra el disparo en el medio de la celda superior del atacante
			disparaAbajo= false;
		}
		else{
			Y = ataca.getY() + hight + hight/2 - altoDisparo + corrimiento;				//y = centra el disparo en el medio de la celda inferior del atacante
			disparaAbajo= true;
		}	
		Point izq = new Point( X , Y);													// [a]- izq es donde el guion toca al corchete (a= atacar)
		
		largo = (int) (der.getX() - izq.getX() + 1);									// largo del disparo = distancia desde izq hasta der
		
		Image imagenAlargada = disparo.getImage(); 
		imagenAlargada = imagenAlargada.getScaledInstance(largo, altoDisparo, java.awt.Image.SCALE_DEFAULT);
		
		disparo = new ImageIcon(imagenAlargada);
		if(disparaAbajo) {
			grafico = new JLabel(disparo);
			
			grafico.setBounds((int)izq.getX(), (int)izq.getY(), largo, altoDisparo);
			grafico.setVisible(true);
			Juego.getJuego().getInterfaz().getPanelMapa().add(grafico);
			grafico.repaint();
		}else {
			graficoBajo = new JLabel(disparo);
			
			graficoBajo.setBounds((int)izq.getX(), (int)izq.getY(), largo, altoDisparo);
			graficoBajo.setVisible(true);
			Juego.getJuego().getInterfaz().getPanelMapa().add(graficoBajo);
			graficoBajo.repaint();
		}
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 3);
	}
}
