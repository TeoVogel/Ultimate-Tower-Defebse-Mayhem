package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelMenu extends JLabel{
	
	public PanelMenu() {
		super();
		setBounds(0, 38, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Interfaz.path + "fff.png"));
		setVisible(true);
	}
		
}