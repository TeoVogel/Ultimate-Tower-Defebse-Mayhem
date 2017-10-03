package Logica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Ente {
	
	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 100;
	protected final int height = 160;
	protected int vida;
		
	protected Point pos;
	
	protected Ente(int x, int y, int v) {
		this.pos = new Point(x, y);
		this.image = new Icon[4];
		vida = v;
	}
	
	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(int dir){
		if(grafico != null){
			grafico.setIcon(image[dir]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
	}
	
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(image[2]);
			grafico.setBounds(pos.x, pos.y, width, height);
			
			grafico.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					vida = 0;
					grafico.setVisible(false);
					grafico.getParent().remove(grafico);
				}
				
			});
		}
		
		return grafico;
	}
	
	public int getVida () {
		return vida;
	}
	
	public void atacar (int p) {
		vida -= p;
	}
	
}