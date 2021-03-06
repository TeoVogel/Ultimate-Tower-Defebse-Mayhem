package grafica;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

import juego.Juego;


public class Interfaz extends JFrame{
	private Container cont;
	private PanelMapa panelMapa;
	private PanelMenu panelMenu;
	private PanelTienda panelTienda;
	public static final String path = "src/assets/";
	
	public Interfaz(Juego juego) {
		super("juego");
	
		cont = getContentPane();		
		cont.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1006, 730); // TODO: fix, 600 + 38 es por la tittle bar de windows
		setResizable(false);

		panelMapa = new PanelMapa();
		panelMenu = new PanelMenu();
		panelTienda = new PanelTienda(juego.getMercado());
		
		cont.add(panelMenu, BorderLayout.NORTH);
		cont.add(panelMapa, BorderLayout.CENTER);
		cont.add(panelTienda, BorderLayout.SOUTH);
		setVisible(true);
		cont.setVisible(true);
		
	}
	
	public PanelMapa getPanelMapa() {
		return panelMapa;
	}
	
	public PanelMenu getPanelMenu() {
		return panelMenu;
	}
	
	public PanelTienda getPanelTienda() {
		return panelTienda;
	}
}