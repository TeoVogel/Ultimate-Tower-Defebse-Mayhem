package juego.ente;

public class AliadoDosCeldas extends Aliado {
	protected Celda celdaInferior;
	
	public AliadoDosCeldas (int vida, int ataque, int cadencia, int rango, int precio, String name) {
		super(vida, ataque, cadencia, rango, precio, name);		
	}
	
	@Override
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
	
	@Override
	public void atacar() {
		super.atacar();
		cad =  
	}
}
