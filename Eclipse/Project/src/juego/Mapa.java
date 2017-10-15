package juego;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import juego.ente.Celda;
import tmp.Aliado;
import tmp.Enemigo;

public class Mapa extends JFrame {

	private JPanel contentPane;
	private Juego juego;
	
	
	private Celda[][] grilla;
	private List<Enemigo> enemigos;
	private List<Aliado> aliados;
	
	public Mapa (Juego j) {
		enemigos = new ArrayList<Enemigo>();
		aliados = new ArrayList<Aliado>();
		juego = j;
		
		// Crea grilla y setea todas las celdas con anterior y siguiente
		Celda[][] grilla = new Celda[6][10];
		for (int i = 0; i < 6; i++)
			for (int ii = 0; ii < 10; ii++)
				grilla[i][ii] = new Celda(i, ii);
		
		for (int i = 0; i < 6; i++)
			grilla[i][0].setDer(grilla[i][1]);
		
		for (int i = 0; i < 6; i++)
			grilla[i][5].setIzq(grilla[i][4]);
			
		for (int i = 0; i < 6; i++)
			for (int ii = 1; ii < 9; ii++) {
				grilla[i][ii].setDer(grilla[i][ii+1]);
				grilla[i][ii].setIzq(grilla[i][ii-1]);
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
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
	
	public List<Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public void addEnemigo (Enemigo e, int fila, int columna) {
		e.getPos().setLocation((new Point(columna*100, fila*100)));
		enemigos.add(e);
		add(e.getGrafico());
	}
	
	public void addAliado (Aliado a, int fila, int columna) {
		a.getPos().setLocation((new Point(columna*100, fila*100)));
		aliados.add(a);
		add(a.getGrafico());
	}
	
	public void mover(){
		List<Integer> enemigosMuertos = new ArrayList<Integer>();
		for (int i=0; i<enemigos.size(); i++) {
			Enemigo e = enemigos.get(i);
			if (e.getVida() <= 0) {
				juego.sumarPuntos(e.getPuntos());
				enemigosMuertos.add(i);
			}
			e.mover();
		}
		for (Integer i : enemigosMuertos) {
			enemigos.remove((int) i);
			System.out.println("Removido");
		}
		System.out.println(enemigos.size() + "      " + juego.getPuntos());
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
