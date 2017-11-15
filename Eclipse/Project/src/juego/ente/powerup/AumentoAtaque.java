package juego.ente.powerup;

import javax.swing.ImageIcon;

import juego.Constantes;
import juego.ente.Personaje;

public class AumentoAtaque extends PowerUp{
	 protected int aumento;

	public AumentoAtaque(){
		super(50, 50);
		aumento=30;
		img = new ImageIcon(Constantes.path + "powerup_shield_enemigo" + ".png");
	}
		
	public void actualizar(){
		if(duracion==0) {
			afectado.setAtaque(afectado.getAtaque()-aumento);
			afectado.setPowerUp(new PowerUp());
		}
		else duracion--;
	}
	
	public void setPersonaje (Personaje p) {
		super.setPersonaje(p);
		afectado.setAtaque(afectado.getAtaque()+aumento);
	}
			
}