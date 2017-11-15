package grafica;

import juego.ente.Ente;

public class GraficoPersonaje extends GraficoEnte {

	protected GraficoDisparo disparo = new RayoLaserAliado();
	
	public GraficoPersonaje(Ente e, String n) {
		super(e, n);
	}

	public void graficarDisparo(Ente e1, Ente e2) {
		disparo.graficar(e1.getGrafico(), e2.getGrafico());
	}
}