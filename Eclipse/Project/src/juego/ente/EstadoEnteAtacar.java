package juego.ente;

import grafica.GraficoEnte;

public class EstadoEnteAtacar extends EstadoEnte{
	
	public EstadoEnteAtacar() {
		index = 2;
	}
	
	public void doAction(GraficoEnte g) {
		g.cambiarGrafico(new EstadoEnteParar());
	}
}
