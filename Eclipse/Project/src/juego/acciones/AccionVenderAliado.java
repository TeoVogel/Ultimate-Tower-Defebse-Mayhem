package juego.acciones;
import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionVenderAliado implements AccionSobreAliado {
	
	private Aliado aliado;
	
	public void ejecutar (Aliado a){
		aliado = a;
		Juego.getJuego().getMercado().agregarMonedas(getPrecio());
		aliado.quitarVida(aliado.getVida());
	}
	
	public int getPrecio () {
		if (aliado == null) {
			return 0;
		}
		float porcentajeVida = ((float)aliado.getVida())/((float)aliado.getMaxVida());
		return (int) (aliado.getPrecio()*porcentajeVida);
	}

}
