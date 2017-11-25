package juego.acciones;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import grafica.Interfaz;
import grafica.PanelMapa;

import juego.ente.Aliado;
import juego.ente.powerup.FactoryPowerUps;
import juego.ente.powerup.PowerUp;
import juego.Juego;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DropPowerUp implements AccionSobreAliado {
	private PowerUp powerUp;
	private JLabel label;
	
	public DropPowerUp(int x, int y, int tipo){
		PanelMapa panelM= Juego.getJuego().getInterfaz().getPanelMapa();
		DropPowerUp yo= this;
		
		label= new JLabel();
		switch(tipo) {
			case (0): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/damage.png") ); 	  break;
			case (1): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/regen.png") ); 		  break;
			case (2): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/heal.png") ); 		  break;
			case (3): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/shield.png") ); 	  break;
			case (4): label.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/attack_speed.png") ); break;
			default: break;
		} 	
		label.setBounds(x+25, y+25, 50, 50);
		label.setVisible(true);
		label.repaint();
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(yo);
				label.setVisible(false);
				label.repaint();
				panelM.remove(label);
			}			
		});
		panelM.add(label);
		
		powerUp = FactoryPowerUps.getPowerUp(tipo);
	}
	
	public void ejecutar (Aliado a) {
		a.setPowerUp(powerUp);
	}
	
	public int getPrecio () {
		return 0;
	}
}