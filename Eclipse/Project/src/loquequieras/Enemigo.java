package loquequieras;

public abstract class Enemigo extends Personaje{
	protected int velocidad;
	private int vel;
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			Visitor v = new AtaqueEnemigo(celda);
			accept(v);
		} else cad = (cad-1)%(cadencia+1);
	}
	
	public void mover() {
		if (vel == velocidad) {
			Celda anterior = celda.getAnterior();
			if (anterior == null) 
				System.out.println("MISSION FAILED");
			else 
				if (anterior.getEnte() == null) {
					anterior.setEnte(this);
					celda.setEnte(null);
					celda = anterior;
				}
		} else vel = (vel-1)%(velocidad+1);
	}
	
}
