package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.BorderLayout;

import juego.ente.Ente;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.IconView;

import juego.Constantes;
import juego.Juego;
import juego.acciones.AccionSpawnearAliado;

public class Interfaz extends JFrame{
	private Container cont;
	private JLabel panelMapa;
	private JLabel panelTienda;
	private JLabel panelMenu;

	public Interfaz() {
		super("juego");
	
		cont=getContentPane();		
		cont.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 746); // TODO: fix, 600 + 38 es por la tittle bar de windows
		

		panelMapa = new PanelMapa();
		panelMenu = new PanelMenu();
		panelTienda = new PanelTienda();
		
		cont.add(panelMenu, BorderLayout.NORTH);
		cont.add(panelMapa, BorderLayout.CENTER);
		cont.add(panelTienda, BorderLayout.SOUTH);
		setVisible(true);
		cont.setVisible(true);
		
	}
	
	public JLabel getPanelMapa() {
		return panelMapa;
	}
	
	public JLabel getPanelMenu() {
		return panelMenu;
	}
	
	public JLabel getPanelTienda() {
		return panelTienda;
	}
	
	public void addEnte(Ente e) {
		JLabel grafico = e.getGrafico();
		panelMapa.add(grafico);
		grafico.repaint();
	}
}