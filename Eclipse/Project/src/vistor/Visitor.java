package vistor;

import ente.Aliado;
import ente.Enemigo;
import ente.Obstaculo;

public interface Visitor {
	public void visit(Aliado a);
	public void visit(Enemigo e);
	public void visit(Obstaculo o);
}
