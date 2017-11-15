package juego.ente.powerup;

import juego.ente.Personaje;

public class TiroRapido extends PowerUp{
	private int original;
	
	public TiroRapido(){
		super(30, 55);
	}
		
	public void actualizar(){
		if(duracion==0) {
			afectado.setCadencia(original);
			afectado.setPowerUp(new PowerUp());
		}
		else duracion--;
	}
		
	public void setPersonaje (Personaje p) {
		super.setPersonaje(p);
		int cadencia=afectado.getCadencia();
		original=cadencia;
		afectado.setCadencia(cadencia*3/4);
	}
}