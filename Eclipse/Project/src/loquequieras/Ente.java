package loquequieras;

public abstract class Ente {
	protected int vida;
	protected JLabel grafico;
	protected Icon[] imagen;
	protected Celda celda;
	
	public int getVida(){
		return vida;
	}
	
	public Celda getCelda() {
		return celda;
	}

}
