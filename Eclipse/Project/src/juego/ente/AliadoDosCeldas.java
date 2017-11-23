package juego.ente;

import grafica.GraficoAliadoDosCeldas;

public class AliadoDosCeldas extends Aliado {
	protected Celda celdaInferior;
	
	public AliadoDosCeldas (int vida, int ataque, int cadencia, int rango, int precio, String name) {
		super(vida, ataque, cadencia, rango, precio, name);	
		grafica = new GraficoAliadoDosCeldas(this, name);	
	}
	
	@Override // Siempre recibe la celda en la que se debe colocar la cabeza
	public void init(Celda c) {
		super.init(c);
		celdaInferior = c.getAbajo();
		celdaInferior.setEnte(this);
	}
	
	@Override
	public void setCelda(Celda c) {
		System.out.println("Hay que redefinir setCelda de aliado 2 celdas");
	}
	
	@Override
	public void quitarVida(int cant) {
		super.quitarVida(cant);
		if (vida <= 0) {
			celdaInferior.setEnte(null);
			celdaInferior = null;
		}
	}
	
	public boolean enviarVisitor() {
		boolean ataco= false;
		v.reset();
		accept(v);
		ataco= v.ataco();
		celda = celdaInferior;
		v.reset();
		accept(v);
		if( !ataco)
			ataco= v.ataco();
		celda = celdaInferior.getArriba();
		return ataco;
	}
	
}
