package juego.ente.EfectoCelda;
import juego.ente.Ente;
import juego.ente.Enemigo;
import grafica.GraficoEfectoCelda;
import juego.ente.Aliado;
import juego.ente.Obstaculo;

public class EfectoCelda {
	
	protected int duracion;
	protected GraficoEfectoCelda grafico;
	
	public EfectoCelda(){
		duracion= 0;
	}
	public void afectar(Ente e) {}
	
	public int actualizar(Ente e){
		return duracion;
	}
	
	public void desafectar(Ente e){}
	
	public void aplicar(Aliado a){}
	
	public void aplicar(Enemigo e){}
	
	public void aplicar(Obstaculo o){}
	
	public void desaplicar(Aliado a){}
	
	public void desaplicar(Enemigo e){}
	
	public void desaplicar(Obstaculo o){}
	
	public GraficoEfectoCelda getGrafico () {
		return grafico;
	}
	
}
