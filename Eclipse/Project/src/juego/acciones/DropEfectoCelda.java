package juego.acciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import grafica.Interfaz;
import grafica.PanelMapa;
import juego.Juego;
import juego.ente.EfectoCelda.EfectoCelda;
import juego.ente.EfectoCelda.FactoryEfectoCelda;

public class DropEfectoCelda implements AccionSobreMapa{
	private JLabel label;
	private int tipo;
	private EfectoCelda efecto;
	
	public DropEfectoCelda(int x, int y, int t){
		tipo= t;
		
		PanelMapa panelM= Juego.getJuego().getInterfaz().getPanelMapa();
		DropEfectoCelda yo= this;
		
		label= new JLabel();
		switch(tipo) {
			case (0): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/acid.png") ); 	  break;
			case (1): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/glue.png") ); 		  break;
			default:  break;
		}
		label.setBounds(x+25, y+25, 50, 50);
		label.setVisible(true);
		label.repaint();
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(yo);
				label.setVisible(false);
				label.repaint();
				panelM.remove(label);
			}			
		});
		panelM.add(label);
		efecto = FactoryEfectoCelda.crearEfectoCelda(tipo);
	}
	
	public void ejecutar (int fila, int columna){
		Juego.getJuego().getMapa().addEfectoCelda(efecto, fila, columna);
	}
	
	public int getPrecio () {
		return 0;
	}
	
}
