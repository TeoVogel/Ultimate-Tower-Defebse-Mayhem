package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Enemigo;
import juego.ente.Aliado;
import juego.ente.Obstaculo;
import juego.ente.Celda;

public class EfectoCelda {
	
	protected Celda celda;
	protected int duracion;
	
	public EfectoCelda( Celda c ){
		celda= c;
	}
	
	public void actualizar(){
		Ente ente=celda.getEnte();
		if(ente!=null) 			
			ente.afectar(this);
	}
	
	public void aplicar(Aliado a){
		
	}
	
	public void aplicar(Enemigo e){
		
	}
	
	public void aplicar(Obstaculo o){
	}
	
}
