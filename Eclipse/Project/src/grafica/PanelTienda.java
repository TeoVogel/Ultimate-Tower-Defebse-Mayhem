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
import juego.ente.powerup.FactoryPowerUps;

public class PanelTienda extends JLabel {
	
	private JLabel monedas;
	
	
	public PanelTienda(Mercado mercado) {
		super();
		setBounds(0, 726, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fff.png"));
		setVisible(true);
		
		monedas = new JLabel("$" + mercado.getMonedas());
		monedas.setForeground(Color.YELLOW);
		monedas.setFont(new Font("", Font.PLAIN, 24));
		monedas.setBounds(900, 0, 100, 50);
		
		add(monedas);
		
		JButton buttonA1 = new JButton("Support");
		buttonA1.setIcon(new ImageIcon(Constantes.path + "a1_frente.png"));
		buttonA1.setBounds(0, 0, 50, 50);
		add(buttonA1);
		buttonA1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new AccionComprarAliado(Constantes.aliados[0]));
			}			
		});
		JButton buttonA2 = new JButton("Commando");
		buttonA2.setIcon(new ImageIcon(Constantes.path + "a2_frente.png"));
		buttonA2.setBounds(50, 0, 50, 50);
		add(buttonA2);
		buttonA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new AccionComprarAliado(Constantes.aliados[1]));
			}			
		});
		JButton buttonA3 = new JButton("Sharpshooter");
		buttonA3.setIcon(new ImageIcon(Constantes.path + "a3_frente.png"));
		buttonA3.setBounds(100, 0, 50, 50);
		add(buttonA3);
		buttonA3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new AccionComprarAliado(Constantes.aliados[2]));
			}			
		});
		JButton buttonA4 = new JButton("Mago");
		buttonA4.setIcon(new ImageIcon(Constantes.path + "a4_frente.png"));
		buttonA4.setBounds(150, 0, 50, 50);
		add(buttonA4);
		buttonA4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new AccionComprarAliado(Constantes.aliados[3]));
			}			
		});
		JButton buttonA5 = new JButton("Tanque");
		buttonA5.setIcon(new ImageIcon(Constantes.path + "a5_frente.png"));
		buttonA5.setBounds(200, 0, 50, 50);
		add(buttonA5);
		buttonA5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new AccionComprarAliado(Constantes.aliados[4]));
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
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_AUMENTO_ATAQUE));
			}			
		});
		JButton buttonPU2 = new JButton("P2");
		buttonPU2.setBounds(350, 0, 50, 50);
		add(buttonPU2);
		buttonPU2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_CURA_GRADUAL));
			}			
		});
		JButton buttonPU3 = new JButton("P3");
		buttonPU3.setBounds(400, 0, 50, 50);
		add(buttonPU3);
		buttonPU3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_CURA_INSTANTANEA));
			}			
		});
		JButton buttonPU4 = new JButton("P4");
		buttonPU4.setBounds(450, 0, 50, 50);
		add(buttonPU4);
		buttonPU4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_ESCUDO));
			}			
		});
		JButton buttonPU5 = new JButton("P5");
		buttonPU5.setBounds(500, 0, 50, 50);
		add(buttonPU5);
		buttonPU5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_TIRO_RAPIDO));
			}			
		});
		
	}
	
	public void setMonedas (int m) {
		monedas.setText("$" + m);
	}
		
}