package juego.ente.powerup;
import juego.ente.Personaje;

public class CuraInstantanea extends PowerUp{
	 protected int cura;

	public CuraInstantanea(){
		super();
		cura=200;
		precio = 75;
	}
	
	public void actualizar(){
		int vida=afectado.getVida();
		int vidaTotal=afectado.getVidaTotal();
		if(vida+cura>=vidaTotal){
			afectado.setVida(vidaTotal);
		}else {
			afectado.setVida(vida+cura);
		}
		afectado.setPowerUp(new PowerUp());
	}
}
