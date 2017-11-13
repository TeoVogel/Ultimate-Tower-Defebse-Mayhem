package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;

public class Pegamento extends EfectoCelda{
	
	public Pegamento() {
		super();
		duracion=40;
	}
	
	public void afectar(Ente e) {
		if(e!=null)	
			e.afectar(this);
	}
	
	public int actualizar(){
		return duracion;
	}
	
	public void desafectar(Ente e){
		if(e!=null)	
			e.desafectar(this);
	}
	
	public void aplicar(Aliado a){}
	
	public void aplicar(Enemigo e){}
	
	public void aplicar(Obstaculo o){}
	
	public void desaplicar(Aliado a){}
	
	public void desaplicar(Enemigo e){}
	
	public void desaplicar(Obstaculo o){}
	
}
