package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.ente.Ente;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.IconView;

import juego.Juego;
import juego.acciones.AccionSpawnearEnemigo;

public class Interfaz extends JFrame{
	private JLabel contentPane;
	private Juego juego;

//	protected final static String path = "C:/Users/Franco/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	protected final static String path = "C:/Users/teo/Documents/TDP/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
//	protected final static String path = "C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 

	
	public Interfaz(Juego j) {
		juego=j;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 638); // TODO: fix, 600 + 38 es por la tittle bar de windows
		contentPane = new JLabel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setIcon(new ImageIcon(path + "fondo.png"));
		
		setVisible(true);
		
		addMouseListener(new MouseAdapter() {
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
		JButton buttonE = new JButton("SpawnE");
		buttonE.setBounds(0, 0, 100, 50);
		add(buttonE);
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.getMercado().addToPlaceHolder(new AccionSpawnearEnemigo(juego));
			}			
		});
		JButton buttonA = new JButton("SpawnA");
		buttonA.setBounds(100, 0, 100, 50);
		add(buttonA);
		buttonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//juego.getMercado().addToPlaceHolder(new AccionSpawnearAliado(juego));
			}			
		});
	}
	
	public void addEnte(Ente e) {
		Grafico g= e.getGrafico();
		add(g);
		/*g.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				remove(g);
				//juego.eliminarEnte(e);
			}
			
		});*/
		g.repaint();
	}
}