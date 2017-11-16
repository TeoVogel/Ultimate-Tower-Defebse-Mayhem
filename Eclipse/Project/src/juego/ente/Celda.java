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
		efecto= new EfectoCelda();
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
		ente = e;
		if(ente!=null)
			efecto.afectar(ente);
	}
	
	public boolean actualizarEfecto(){
		int duracion=efecto.actualizar(ente);
		if(duracion == 0) {
			efecto.getGrafico().eliminar();
			efecto= new EfectoCelda();
			return true;
		}
		return false;
	}
	
	public void RemoveEnte() {
		efecto.desafectar(ente);
		ente=null;
	}
	
	public EfectoCelda getEfecto() {
		return efecto;
	}
	
	public void setEfecto(EfectoCelda efecto) {
		this.efecto = efecto;
		efecto.getGrafico().initGrafico(this);
	}

}
