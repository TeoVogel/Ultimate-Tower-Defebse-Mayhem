package loquequieras;

public abstract class Personaje extends Ente{
	protected int ataque;
	protected int rango;
	protected int cadencia;
	protected EfectoPersonaje efecto;
	
	public int getAtaque() {
		return ataque;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getCadencia() {
		return cadencia;
	}
	
	public EfectoPersonaje getEfecto() {
		return efecto;
	}
	
	public abstract void atacar();
}
