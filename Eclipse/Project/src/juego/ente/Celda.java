package juego.ente;

import juego.ente.EfectoCelda.EfectoCelda;

public class Celda {
	
	public final int fila, columna;
	
	private EfectoCelda efecto;
	private Ente ente;
	private Celda izq, der;
	
	public Celda (int f, int c) {
		fila = f;
		columna = c;
	}
	
	public Celda getIzq() {
		return izq;
	}
	
	public Celda getDer() {
		return der;
	}
	
	public void setIzq(Celda c) {
		izq = c;
	}
	
	public void setDer(Celda c) {
		der = c;
	}
	
	public Ente getEnte() {
		return ente;
	}
	
	public void setEnte(Ente e) {
		if(ente != null) {
			ente = e;
			efecto.afectarEnte(ente);
		}
	}
	
	public int actualizarEfecto(){
		int duracion= efecto.actualizar(ente);
		if(duracion == 0) {
			efecto = new EfectoCelda();
		}
		return duracion;
	}
	
	public void removeEnte() {
		efecto.desafectarEnte(ente);
		ente=null;
	}
	
	public EfectoCelda getEfecto() {
		return efecto;
	}
	
	public void setEfecto(EfectoCelda efecto) {
		this.efecto = efecto;
	}

}
