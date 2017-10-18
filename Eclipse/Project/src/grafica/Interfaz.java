package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import juego.Juego;

public class Interfaz{
	private JFrame frame;
	private JPanel contentPane;
	private Juego juego;
	
	public Interfaz(Juego j){
		juego = j;
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		frame.addMouseListener(new MouseAdapter() {
				@Override
	            public void mousePressed(MouseEvent e) {
					juego.ejecutarMercado(e.getX()/100, e.getY()/100);
	            }
	            @Override
	            public void mouseReleased(MouseEvent e) {}
			}
		);
	}
	
	public void SpawnE() {
		JButton buttonE = new JButton("SpawnE");
		buttonE.setBounds(0, 0, 100, 50);
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.SpawnE();
			}			
		});
		frame.add(buttonE);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public void addGrafico(Grafico g){
		frame.add(g.getLabel());
		g.initGrafico();
		g.getLabel().setVisible(true);
		g.getLabel().repaint();
	
	}
}
