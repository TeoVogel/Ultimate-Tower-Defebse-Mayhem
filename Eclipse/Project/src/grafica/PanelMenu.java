package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;

public class PanelMenu extends JLabel{
	
	public PanelMenu() {
		super();
		setBounds(0, 38, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fff.png"));
		setVisible(true);
			
	}
	
}
