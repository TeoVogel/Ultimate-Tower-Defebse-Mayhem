package juego.ente.powerup;
import juego.ente.Personaje;

public class CuraInstantanea extends PowerUp{
	 protected int cura;

	public CuraInstantanea(Personaje p){
		super(p);
		cura=200;
	}
	
	public void actualizar(){
		afectado.curar(cura);
		afectado.setPowerUp(new PowerUp(afectado));
	}
}
