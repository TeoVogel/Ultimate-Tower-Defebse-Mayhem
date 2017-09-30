package loquequieras;

public abstract class Enemigo {
	protected int velodidad;
	
	public void accept(Visitor v) {
		v.visit(this);
	}

}
