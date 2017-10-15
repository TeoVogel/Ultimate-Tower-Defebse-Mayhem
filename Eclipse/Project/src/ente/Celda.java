package ente;

public class Celda {
	private int fila, columna;
	private EfectoCelda efecto;
	private Ente ente;
	private Celda izq, der;
	
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
	
	public EfectoCelda getEfecto() {
		return efecto;
	}
	
	public void setEnte(Ente e) {
		ente = e;
	}
}
