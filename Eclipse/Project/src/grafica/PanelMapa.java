package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Constantes;
import juego.Juego;
import juego.Mapa;

public class PanelMapa extends JLabel{
	
	Mapa mapa;
	
	public PanelMapa(Mapa m) {
		super();
		mapa=m;
		setBounds(0, 88, 1000, 638);
		setLayout(null);
		setIcon(new ImageIcon(Constantes.path + "fondo.png"));
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				if (Juego.getJuego().getMercado().isPlaceHolderFull()) {
					int columna = e.getX()/100,
					    fila    = e.getY()/100;
					Juego.getJuego().getMercado().getPlaceHolderContent().ejecutar(mapa.getCelda(fila, columna));
				}
            }
			
            @Override
            public void mouseReleased(MouseEvent e) {}
		});	
	}
	
}
