package loquequieras;

public abstract class Aliado extends Personaje{
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		Visitor v = new AtaqueAliado(celda);
		accept(v);
	}
}
