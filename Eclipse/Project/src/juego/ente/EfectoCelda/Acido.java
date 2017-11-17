package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import grafica.GraficoEfectoCelda;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Comprable;
import juego.ente.Enemigo;

public class Acido extends EfectoCelda {
	
	int corrosion;
	
	public Acido() {
		super();
		duracion=20;
		corrosion=20;
		precio = 75;
		grafico = new GraficoEfectoCelda("efecto1.gif");
	}
	
	public void afectar(Ente e) {}
	
	public int actualizar(Ente e){
		if(e!=null)	
			e.afectar(this);
		duracion--;
		return duracion;
	}
	
	public void desafectar(Ente e){}
	
	public void aplicar(Aliado a){
		a.quitarVida(corrosion);
	}
	
	public void aplicar(Enemigo e){
		e.quitarVida(corrosion);
	}
	
	public void aplicar(Obstaculo o){
		o.quitarVida(corrosion);
	}
	
	public void desaplicar(Aliado a){}
	
	public void desaplicar(Enemigo e){}
	
	public void desaplicar(Obstaculo o){}
	
}
