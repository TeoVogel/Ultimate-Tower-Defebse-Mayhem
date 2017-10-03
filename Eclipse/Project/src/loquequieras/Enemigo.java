package loquequieras;

public abstract class Enemigo extends Personaje{
	protected int velodidad;
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		Visitor v = new AtaqueEnemigo(celda);
		accept(v);
	}
	
	public void mover() {
		
	}
	
}
