package juego.ente;

import javax.swing.JLabel;
import juego.visitor.DisparoAliado;
import juego.visitor.Visitor;
import grafica.Grafico;
import grafica.GraficoAliado;

public class Aliado extends Personaje implements Comprable{
	protected int precio;
	
	public Aliado(int vida, Celda celda, int ataque, int cadencia, int rango, int precio, String name) {
		super(vida, celda, ataque, cadencia, rango);
		this.precio = precio;
		grafica = new GraficoAliado(this, name);
		v = new DisparoAliado(this);
	}

	public Aliado(int vida, int ataque, int cadencia, int rango, int precio, String name) {
		super(vida, ataque, cadencia, rango);
		this.precio = precio;
		grafica = new GraficoAliado(this, name);
		v = new DisparoAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia-1) { // Cad se resetea en el visitor si el ataque fue exitoso
			v.reset();
			accept(v);
		} else cad = (cad+1)%(cadencia);
	}
	
	public int getPrecio() {
		return precio;
	}
}
