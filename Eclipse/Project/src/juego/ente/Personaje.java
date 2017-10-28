package juego.ente;
import juego.visitor.*;
import juego.ente.powerup.PowerUp;

public abstract class Personaje extends Ente{
	
	protected PowerUp estado;
	protected int ataque;
	protected int rango;
	protected int cadencia, cad;
	protected Visitor v;
	protected int vidaTotal;
	
	public Personaje(int vida, int ataque, int cadencia, int rango) {
		super(vida);
		this.ataque = ataque;
		this.cadencia = cadencia;
		cad = 0;
		this.rango = rango;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public void curar(int c){
		if(vida+c>=vidaTotal){
			vida=vidaTotal;
		}else {
			vida+=c;
		}	
	}
	
	public void setPowerUp(PowerUp p){
		estado= p;
	}
	
	public int getVidaTotal(){
		return vidaTotal;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getCadencia() {
		return cadencia;
	}
	
	public void setCad(int c) {
		cad = c;
	}
	
	public abstract void atacar();
}
