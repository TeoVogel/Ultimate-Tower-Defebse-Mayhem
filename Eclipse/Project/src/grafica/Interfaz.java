package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

import juego.ente.Ente;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.IconView;

import juego.Constantes;
import juego.Juego;
import juego.acciones.AccionSpawnearAliado;

public class Interfaz extends JFrame{
	private Container cont;
	private PanelMapa panelMapa;
	private JLabel panelTienda;
	private PanelMenu panelMenu;

	public Interfaz() {
		super("juego");
		
		panelTienda = new JLabel();
		cont=getContentPane();
		
		cont.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 696); // TODO: fix, 600 + 38 es por la tittle bar de windows
		
		panelMenu = new PanelMenu();
		panelMapa=new PanelMapa(Juego.getJuego().getMapa());
		
		cont.add(panelMenu, BorderLayout.NORTH);
		cont.add(panelMapa, BorderLayout.CENTER);

		setVisible(true);
		cont.setVisible(true);
		
	}
	
	public void crearBotonSpawn(){
		JButton buttonS = new JButton("Support");
		buttonS.setBounds(0, 0, 100, 50);
		panelMenu.add(buttonS);
		buttonS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[0]));
			}			
		});
		JButton buttonC = new JButton("Commando");
		buttonC.setBounds(100, 0, 100, 50);
		panelMenu.add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[1]));
			}			
		});
		JButton buttonSh = new JButton("Sharpshooter");
		buttonSh.setBounds(200, 0, 100, 50);
		panelMenu.add(buttonSh);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[2]));
			}			
		});
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