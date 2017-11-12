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
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionComprarAliado(Constantes.aliados[0]));
			}			
		});
		JButton buttonC = new JButton("Commando");
		buttonC.setIcon(new ImageIcon(Constantes.path + "a2_frente.png"));
		buttonC.setBounds(50, 0, 50, 50);
		add(buttonC);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionComprarAliado(Constantes.aliados[1]));
			}			
		});
		JButton buttonSh = new JButton("Sharpshooter");
		buttonSh.setIcon(new ImageIcon(Constantes.path + "a3_frente.png"));
		buttonSh.setBounds(100, 0, 50, 50);
		add(buttonSh);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionComprarAliado(Constantes.aliados[2]));
			}			
		});
		JButton buttonM = new JButton("Mago");
		buttonM.setIcon(new ImageIcon(Constantes.path + "a4_frente.png"));
		buttonM.setBounds(150, 0, 50, 50);
		add(buttonM);
		buttonSh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionComprarAliado(Constantes.aliados[3]));
			}			
		});
		JButton buttonT = new JButton("Tanque");
		buttonT.setIcon(new ImageIcon(Constantes.path + "a5_frente.png"));
		buttonT.setBounds(200, 0, 50, 50);
		add(buttonT);
		buttonT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getJuego().getMercado().addToPlaceHolder(new AccionComprarAliado(Constantes.aliados[4]));
			}			
		});
	}
	
	public void setMonedas (int m) {
		monedas.setText(String.valueOf(m));
	}
		
}