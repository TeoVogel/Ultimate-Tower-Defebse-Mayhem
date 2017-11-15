	package grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Ente;
import juego.Juego;

public class GraficoAliado extends GraficoPersonaje {

	public GraficoAliado(Ente e, String n) {
		super(e, n);
	}
	
	public void initGrafico (Celda c) {
		super.initGrafico(c);
	
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Juego.getJuego().getMercado().isAccionSobreAliado()) {
					Juego.getJuego().getMercado().getAccionSobreAliado().ejecutar((Aliado)ente);
				}
			}
			
		});
	}

	
}