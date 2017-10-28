package juego.ente;

import grafica.GraficoEnte;
import javax.swing.JLabel;
import juego.visitor.Visitor;

public abstract class Ente {
	
	protected int vida;
	protected Celda celda;
	protected GraficoEnte grafica;
	protected EstadoEnte estado;
	
	public Ente(int vida) {
		this.vida = vida;
		estado = new EstadoEnteParar();
	}
	
	public void init (Celda c) {
		celda = c;
		celda.setEnte(this);
		grafica.initGrafico(c);
	}

	public JLabel getGrafico () {
		return grafica;
	}
	
	public void setCelda(Celda celda) {
		this.celda = celda;
	}
	
	public int getVida(){
		return vida;
	}
	
	public Celda getCelda() {
		return celda;
	}
	
	public abstract void accept(Visitor v);
	
	public void quitarVida(int cant) {
		vida -= cant;
		if (vida <= 0) {
			// TODO: Matar bien al chabon, probablemente haya que redefinir
			celda.setEnte(null);
			celda = null;
		}
	}
	
	public EstadoEnte getEstado () {
		return estado;
	}
	
	public void setEstado (EstadoEnte e) {
		estado = e;
	}
	
}
