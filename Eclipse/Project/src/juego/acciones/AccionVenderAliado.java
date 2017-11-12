package juego.acciones;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionVenderAliado implements Accion {
	
	private Aliado aliado;
	
	public void ejecutar (Celda c){
		aliado = (Aliado) c.getEnte();
		Juego.getJuego().getMercado().agregarMonedas(getPrecio());
		aliado.quitarVida(aliado.getVida());
	}
	
	public int getPrecio () {
		float porcentajeVida = ((float)aliado.getVida())/((float)aliado.getMaxVida());
		return (int) (aliado.getPrecio()*porcentajeVida);
	}

}
