package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import juego.Mercado;
import juego.acciones.AccionComprarAliado;
import juego.acciones.AccionComprarPowerUp;
import juego.acciones.AccionVenderAliado;
import juego.ente.powerup.AumentoAtaque;
import juego.ente.powerup.CuraInstantanea;
import juego.ente.powerup.Escudo;
import juego.ente.powerup.TiroRapido;

public class PanelTienda extends JLabel {
	
	private JLabel monedas;
	
	
	public PanelTienda(Mercado mercado) {
		super();
		setBounds(0, 726, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fff.png"));
		setVisible(true);
		
		monedas = new JLabel("" + mercado.getMonedas());
		monedas.setForeground(Color.YELLOW);
		monedas.setFont(new Font("", Font.PLAIN, 20));
		monedas.setBounds(900, 0, 100, 50);
		
		add(monedas);
		
		JButton buttonS = new JButton("Support");
		buttonS.setIcon(new ImageIcon(Constantes.path + "a1_frente.png"));
		buttonS.setBounds(0, 0, 50, 50);
		add(buttonS);
		buttonS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionInsertar(new AccionComprarAliado(Constantes.aliados[0]));
			}			
		});
		JButton buttonC = new JButton("Commando");
		buttonC.setIcon(new ImageIcon(Constantes.path + "a2_frente.png"));
		buttonC.setBounds(50, 0, 50, 50);
		add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionInsertar(new AccionComprarAliado(Constantes.aliados[1]));
			}			
		});
		JButton buttonSh = new JButton("Sharpshooter");
		buttonSh.setIcon(new ImageIcon(Constantes.path + "a3_frente.png"));
		buttonSh.setBounds(100, 0, 50, 50);
		add(buttonSh);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionInsertar(new AccionComprarAliado(Constantes.aliados[2]));
			}			
		});
		JButton buttonM = new JButton("Mago");
		buttonM.setIcon(new ImageIcon(Constantes.path + "a4_frente.png"));
		buttonM.setBounds(150, 0, 50, 50);
		add(buttonM);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionInsertar(new AccionComprarAliado(Constantes.aliados[3]));
			}			
		});
		JButton buttonT = new JButton("Tanque");
		buttonT.setIcon(new ImageIcon(Constantes.path + "a5_frente.png"));
		buttonT.setBounds(200, 0, 50, 50);
		add(buttonT);
		buttonT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionInsertar(new AccionComprarAliado(Constantes.aliados[4]));
			}			
		});
		
		
		JButton buttonV = new JButton("$");
		buttonV.setBounds(250, 0, 50, 50);
		add(buttonV);
		buttonV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(new AccionVenderAliado());
			}			
		});
		

		JButton buttonPU1 = new JButton("P1");
		buttonPU1.setBounds(300, 0, 50, 50);
		add(buttonPU1);
		buttonPU1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(new AccionComprarPowerUp(new AumentoAtaque()));
			}			
		});
		JButton buttonPU2 = new JButton("P2");
		buttonPU2.setBounds(350, 0, 50, 50);
		add(buttonPU2);
		buttonPU2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(new AccionComprarPowerUp(new CuraInstantanea()));
			}			
		});
		JButton buttonPU3 = new JButton("P3");
		buttonPU3.setBounds(400, 0, 50, 50);
		add(buttonPU3);
		buttonPU3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(new AccionComprarPowerUp(new Escudo()));
			}			
		});
		JButton buttonPU4 = new JButton("P4");
		buttonPU4.setBounds(450, 0, 50, 50);
		add(buttonPU4);
		buttonPU4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(new AccionComprarPowerUp(new TiroRapido()));
			}			
		});
		
	}
	
	public void setMonedas (int m) {
		monedas.setText(String.valueOf(m));
	}
		
}