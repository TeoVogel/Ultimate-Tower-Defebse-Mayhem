package juego.ente;
import juego.visitor.*;
import juego.ente.powerup.*;

public abstract class Personaje extends Ente{
	
	protected PowerUp estado;
	protected int ataque;
	protected int rango;
	protected int cadencia, cad;
	protected Visitor v;
	protected int vidaTotal;
	
	public Personaje(int vida, int ataque, int cadencia, int rango) {
		super(vida);
<<<<<<< HEAD
		estado= new PowerUp();
=======
		estado = new PowerUp(this);
>>>>>>> 5e5b9404466d4cb3868da5460e39b12c44774bdc
		this.ataque = ataque;
		this.cadencia = cadencia;
		cad = 0;
		this.rango = rango;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public int getCadencia() {
		return cadencia;
	}
	
	public int getVidaTotal() {
		return vidaTotal;
	}
	
	public int getRango() {
		return rango;
	}
	
	public void setRango(int r) {
		rango = r;
	}
	
<<<<<<< HEAD
	public void setPowerUp(PowerUp p){
		estado= p;
		p.setPersonaje(this);
=======
	public void setPowerUp(PowerUp p) {
		estado = p;
>>>>>>> 5e5b9404466d4cb3868da5460e39b12c44774bdc
	}
	
	public void setVida(int v) {
		vida = v;
	}
	
	public void setAtaque(int a) {
		ataque = a;
	}
	
	public void setCadencia(int c) {
		cadencia = c;
	} 
	
	public void setCad(int c) {
		cad = c;
	}
	
	public void actualizarPowerUp() {
		estado.actualizar();
	}
	
	public void atacar() {
		if (cad == cadencia-1) { 
			if(enviarVisitor())
				cad = 0;
		} else 
			cad = (cad+1)%(cadencia);
	}
	
	public boolean enviarVisitor() {
		v.reset();
		accept(v);
		return v.ataco();
	}

}
