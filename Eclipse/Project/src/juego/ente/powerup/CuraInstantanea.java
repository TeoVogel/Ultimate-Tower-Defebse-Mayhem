package juego.ente.powerup;

public class CuraInstantanea extends PowerUp{
	 protected final static int cura = 200;

	public CuraInstantanea(){
		super(1, 75);
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
