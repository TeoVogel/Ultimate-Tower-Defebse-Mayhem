package juego.ente;

import grafica.GraficoEnte;

import javax.swing.Icon;
import javax.swing.JLabel;
import juego.visitor.Visitor;
import juego.ente.EfectoCelda.EfectoCelda;

public abstract class Ente {
	
	protected int vida;
	protected int maxVida;
	protected Celda celda;
	protected GraficoEnte grafica;
	protected EstadoEnte estado;
	
	public Ente(int vida) {
		this.vida = vida;
		this.maxVida = vida;
		estado = new EstadoEnteParar();
	}
	
	public void init (Celda c) {
		celda = c;
		celda.setEnte(this);
		grafica.initGrafico(c);
	}

	public GraficoEnte getGrafico () {
		return grafica;
	}
	
	public void setCelda(Celda celda) {
		this.celda = celda;
	}
	
	public int getVida(){
		return vida;
	}
	
	public int getMaxVida () {
		return maxVida;
	}
	
	public Celda getCelda() {
		return celda;
	}
	
	public abstract void accept(Visitor v);
	
	public void quitarVida(int cant) {
		vida -= cant;
		grafica.actualizarVida();
		if (vida <= 0) {
			estado = new EstadoEnteMorir();
			grafica.morir();
			celda.RemoveEnte();
			celda = null;
		}
	}
	
	public EstadoEnte getEstado () {
		return estado;
	}
	
	public abstract void afectar(EfectoCelda e);
	
	public abstract void desafectar(EfectoCelda e);
	
	public void setEstado (EstadoEnte e) {
		if (!estado.esMorir())
			estado = e;
	}
	
}
