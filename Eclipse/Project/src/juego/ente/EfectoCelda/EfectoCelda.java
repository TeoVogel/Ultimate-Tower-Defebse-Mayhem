package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Enemigo;
import juego.ente.Aliado;
import juego.ente.Obstaculo;

public class EfectoCelda {
	
	protected int duracion;
	
	public EfectoCelda( ){
		duracion=1;
	}
	
	public void afectarEnte(Ente e){
		Ente ente=e;
		if(ente!=null) 			
			ente.afectar(this);
	}
	
	public int actualizar(Ente e){}
	
	public void desafectarEnte(Ente e){
		Ente ente=e;
		if(ente!=null) 			
			ente.desafectar(this);
	}
	
	public void aplicar(Aliado a){}
	
	public void aplicar(Enemigo e){}
	
	public void aplicar(Obstaculo o){}
	
	public void desaplicar(Aliado a){}
	
	public void desaplicar(Enemigo e){}
	
	public void desaplicar(Obstaculo o){}
}
