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
import juego.acciones.AccionSpawnearEnemigo;

public class Interfaz extends JFrame{
	private Container cont;
	private JLabel panelMapa;
	private JLabel panelTienda;
	private JLabel panelMenu;
	private Juego juego; 

	public Interfaz(Juego j) {
		super("juego");
		juego=j;
		panelMapa = new JLabel();
		panelMenu = new JLabel();
		panelTienda = new JLabel();
		cont=getContentPane();
		
		cont.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 696); // TODO: fix, 600 + 38 es por la tittle bar de windows
		
		panelMenu.setBounds(0, 38, 1000, 50);
		panelMapa.setBounds(0, 88, 1000, 638);
		cont.add(panelMenu, BorderLayout.NORTH);
		cont.add(panelMapa, BorderLayout.CENTER);
		panelMapa.setLayout(null);
		panelMenu.setLayout(null);
		panelMenu.setIcon(new ImageIcon(Constantes.path + "fff.png"));
		panelMapa.setIcon(new ImageIcon(Constantes.path + "fondo.png"));
		setVisible(true);
		cont.setVisible(true);
		panelMapa.setVisible(true);
		panelMenu.setVisible(true);
		
		panelMapa.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (juego.getMercado().isPlaceHolderFull()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					juego.getMercado().getPlaceHolderContent().ejecutar(juego.getMapa().getCelda(fila, columna));
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
	public void crearBotonSpawn(){
		JButton buttonS = new JButton("Support");
		buttonS.setBounds(0, 0, 100, 50);
		panelMapa.add(buttonS);
		buttonS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[0], juego));
			}			
		});
		JButton buttonC = new JButton("Commando");
		buttonC.setBounds(100, 0, 100, 50);
		panelMapa.add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[1], juego));
			}			
		});
		JButton buttonSh = new JButton("Sharpshooter");
		buttonSh.setBounds(200, 0, 100, 50);
		panelMapa.add(buttonSh);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.getMercado().addToPlaceHolder(new AccionSpawnearAliado(Constantes.aliados[2], juego));
			}			
		});
	}
	
	public void addEnte(Ente e) {
		JLabel grafico = e.getGrafico();
		panelMapa.add(grafico);
		grafico.repaint();
		/*g.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				remove(g);
				//ente.eliminarse(e);
			}
			
		});*/
	}
}