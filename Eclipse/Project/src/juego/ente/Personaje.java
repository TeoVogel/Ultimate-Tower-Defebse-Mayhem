package juego.ente;
import juego.visitor.*;
import juego.ente.powerup.*;
import grafica.GraficoPersonaje;

public abstract class Personaje extends Ente{
	
	protected PowerUp powerUp;
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
	
	public void init (Celda c) {
		super.init(c);
		if (powerUp == null) {
			powerUp = new PowerUp();
		}
		((GraficoPersonaje) grafica).setPowerUp(powerUp);
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
	
	public void setPowerUp(PowerUp p) {
		powerUp = p;
		p.setPersonaje(this);
		((GraficoPersonaje) grafica).setPowerUp(p);
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
		if (powerUp != null)
			powerUp.actualizar();
	}
	
	public void atacar() {
		if (cad == cadencia-1){ 
			if( enviarVisitor() )
				cad = 0;
		}else 
			cad = (cad+1)%(cadencia);
	}
	
	// Es para poder forzar un ataque sin modificar la cadencia
	public boolean enviarVisitor() {
		v.reset();
		accept(v);
		return v.ataco();
	}

}
