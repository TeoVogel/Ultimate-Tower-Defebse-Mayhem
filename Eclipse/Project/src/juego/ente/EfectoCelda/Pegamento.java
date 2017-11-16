package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import grafica.GraficoEfectoCelda;
import juego.ente.Aliado;
import juego.ente.Enemigo;

public class Pegamento extends EfectoCelda{
	
	int velocidad;
	
	public Pegamento() {
		super();
		duracion=40;
		velocidad=0;
		grafico = new GraficoEfectoCelda("efecto2.gif");
	}
	
	public void afectar(Ente e) {
		if(e!=null)	
			e.afectar(this);
	}
	
	public int actualizar(Ente e){
		duracion--;
		return duracion;
	}
	
	public void desafectar(Ente e){
		if(e!=null)	
			e.desafectar(this);
	}
	
	public void aplicar(Aliado a){}
	
	public void aplicar(Enemigo e){
		velocidad= e.getVelocidad();
		e.setVelocidad(velocidad*2);
	}
	
	public void aplicar(Obstaculo o){}
	
	public void desaplicar(Aliado a){}
	
	public void desaplicar(Enemigo e){
		e.setVelocidad(velocidad);
	}
	
	public void desaplicar(Obstaculo o){}
	
}
