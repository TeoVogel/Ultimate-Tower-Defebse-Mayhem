package loquequieras;

public class Mapa {
	private Celda[][] grilla;
	private Secuencia<Enemigo> enemigos;
	private Secuencia<Aliados> aliados;
	
	public void ataqueEnemigo() {
		for (Enemigo e: enemigos) {
			int fil = e.getCelda().getFila();
			int col = e.getCelda().getColumna();
			int r = e.getRango();
			AtaqueEnemigo v = new AtaqueEnemigo(e.getAtaque());
			boolean ataco = false;
			
			for (i = col-1; i >= col-r && !ataco; i--)
				ataco = grilla[fil][i].accept(v);
			
		}
			
	}
}
