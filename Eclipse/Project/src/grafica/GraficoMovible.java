package grafica;

import juego.ente.Ente;

public abstract class GraficoMovible extends Grafico {
	
	protected GraficoMovible(Ente e, String name) {
		super(e, name);
	}

	public abstract void mover ();
	
}
