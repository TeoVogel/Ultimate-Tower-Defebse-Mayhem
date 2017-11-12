package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import juego.ente.Aliado;
import juego.ente.Enemigo;

public class Acido extends EfectoCelda{
	
	int corrosion;
	
	public Acido() {
		super();
		duracion=40;
		corrosion=3;
	}
	
	public void afectarEnte(Ente e){}
	
	public void actualizar(Ente e){
		Ente ente=e;
		if(ente!=null) 			
			ente.afectar(this);
	}
	
	public void desafectarEnte(Ente e){}
	
	public void aplicar(Enemigo e){
		e.quitarVida(corrosion);
	}
	public void desaplicar(Enemigo e){}
	
	public void aplicar(Aliado a){
		a.quitarVida(corrosion);
	}
	public void desaplicar(Aliado a){}
	
	public void aplicar(Obstaculo o){
		o.quitarVida(corrosion);
	}
	public void desaplicar(Obstaculo o){}
}