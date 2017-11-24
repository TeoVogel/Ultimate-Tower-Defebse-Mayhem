package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import juego.Juego;
import juego.Mercado;
import juego.acciones.*;
import juego.ente.EfectoCelda.FactoryEfectoCelda;
import juego.ente.powerup.FactoryPowerUps;

public class PanelTienda extends JLabel {
	
	private JLabel monedas;
	
	public PanelTienda(Mercado mercado) {
		super();
		setBounds(0, 726, 1000, 50);
		setLayout(null);
		setIcon(new ImageIcon(Interfaz.path + "fff.png"));
		setVisible(true);
		
		monedas = new JLabel("$" + mercado.getMonedas());
		monedas.setForeground(Color.YELLOW);
		monedas.setFont(new Font("", Font.PLAIN, 24));
		monedas.setBounds(900, 0, 100, 50);
		
		add(monedas);
		
		JButton buttonA1 = new JButton("Support");
		buttonA1.setIcon(new ImageIcon(Interfaz.path + "a1_frente.png"));
		buttonA1.setBounds(0, 0, 50, 50);
		add(buttonA1);
		buttonA1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarSupport());
			}			
		});
		JButton buttonA2 = new JButton("Commando");
		buttonA2.setIcon(new ImageIcon(Interfaz.path + "a2_frente.png"));
		buttonA2.setBounds(50, 0, 50, 50);
		add(buttonA2);
		buttonA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarCommando());
			}			
		});
		JButton buttonA3 = new JButton("Sharpshooter");
		buttonA3.setIcon(new ImageIcon(Interfaz.path + "a3_frente.png"));
		buttonA3.setBounds(100, 0, 50, 50);
		add(buttonA3);
		buttonA3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarSharpshooter());
			}			
		});
		JButton buttonA4 = new JButton("Mago");
		buttonA4.setIcon(new ImageIcon(Interfaz.path + "a4_frente.png"));
		buttonA4.setBounds(150, 0, 50, 50);
		add(buttonA4);
		buttonA4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarMago());
			}			
		});
		JButton buttonA5 = new JButton("Tanque");
		buttonA5.setIcon(new ImageIcon(Interfaz.path + "a6_frente.gif"));
		buttonA5.setBounds(200, 0, 50, 50);
		add(buttonA5);
		buttonA5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarAliadoDosCeldas() );
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
		buttonPU1.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/damage.png"));
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
		buttonPU2.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/regen.png"));
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
		buttonPU3.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/heal.png"));
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
		buttonPU4.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/shield.png"));
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
		buttonPU5.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/attack_speed.png"));
		buttonPU5.setBounds(500, 0, 50, 50);
		add(buttonPU5);
		buttonPU5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreAliado(
						new AccionComprarPowerUp(FactoryPowerUps.POWERUP_TIPO_TIRO_RAPIDO));
			}			
		});
		

		JButton buttonEC1 = new JButton("E1");
		buttonEC1.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/acid.png"));
		buttonEC1.setBounds(550, 0, 50, 50);
		add(buttonEC1);
		buttonEC1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(
						new AccionComprarEfectoCelda(FactoryEfectoCelda.EFECTO_CELDA_ACIDO));
			}			
		});
		JButton buttonEC2 = new JButton("E2");
		buttonEC2.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/glue.png"));
		buttonEC2.setBounds(600, 0, 50, 50);
		add(buttonEC2);
		buttonEC2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(
						new AccionComprarEfectoCelda(FactoryEfectoCelda.EFECTO_CELDA_PEGAMENTO));
			}			
		});
		
		JButton buttonBomb = new JButton("B");
		buttonBomb.setIcon(new ImageIcon(Interfaz.path + "icon_powerUp/bomb.png"));
		buttonBomb.setBounds(650, 0, 50, 50);
		add(buttonBomb);
		buttonBomb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addAccionSobreMapa(new ComprarBomba());
			}			
		});
		
	}
	
	public void setMonedas (int m) {
		monedas.setText("$" + m);
	}
		
}