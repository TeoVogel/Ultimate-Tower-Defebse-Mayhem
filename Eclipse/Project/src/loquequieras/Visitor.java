package loquequieras;

public interface Visitor {
	public void visit(Aliado a);
	public void visit(Enemigo e);
	public void visit(Obstaculo o);

}
