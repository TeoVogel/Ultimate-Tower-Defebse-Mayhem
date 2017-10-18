package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.ente.Ente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.Juego;
import juego.acciones.AccionSpawnearEnemigo;

public class Interfaz extends JFrame{
	private JPanel contentPane;
	private Juego juego;
	
	public Interfaz(Juego j) {
		juego=j;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (juego.getMercado().isPlaceHolderFull()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					juego.getMercado().getPlaceHolderContent().ejecutar(fila, columna);
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
	public void crearBotonSpawn(){
		JButton buttonE = new JButton("SpawnE");
		buttonE.setBounds(0, 0, 100, 50);
		add(buttonE);
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.getMercado().addToPlaceHolder(new AccionSpawnearEnemigo(juego));
			}			
		});
	}
	
	public void addEnte(Ente e) {
		Grafico g= e.getGrafico();
		add(g);
		g.initGrafico(e.getCelda());
		g.setVisible(true);
		g.repaint();
	}
}