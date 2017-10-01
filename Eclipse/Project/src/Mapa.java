

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import loquequieras.Celda;

public class Mapa extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	
	
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	//private List<Aliados> aliados;
	
	public Mapa (Juego j) {
		enemigos = new ArrayList<Enemigo>();
		juego = j;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (juego.getMercado().isPlaceHolderFull()) {
					int columna = e.getX()/100,
					    fila = e.getY()/100;
					juego.getMercado().getPlaceHolderContent().ejecutar(fila, columna);
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {
            }
		});
	}
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e, int fila, int columna) {
		e.getPos().setLocation((new Point(columna*100, fila*100)));
		enemigos.add(e);
		add(e.getGrafico());
	}
	
	public void addEnemigoRandom (Enemigo e) {
		enemigos.add(e);
		add(e.getGrafico());
	}
	
	/*public void ataqueEnemigo() {
		for (Enemigo e: enemigos) {
			int fil = e.getCelda().getFila();
			int col = e.getCelda().getColumna();
			int r = e.getRango();
			AtaqueEnemigo v = new AtaqueEnemigo(e.getAtaque());
			boolean ataco = false;
			
			for (i = col-1; i >= col-r && !ataco; i--)
				ataco = grilla[fil][i].accept(v);
			
		}
		
	}*/
	
}
