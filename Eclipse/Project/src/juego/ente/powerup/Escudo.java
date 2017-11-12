package juego.ente.powerup;

import juego.ente.Personaje;

import javax.swing.ImageIcon;

import juego.Constantes;
import juego.ente.Celda;

public class Escudo extends PowerUp{
	 protected int original;
		public Escudo(Personaje p){
			super(p,30);
			img = new ImageIcon(Constantes.path + "powerup_shield_aliado" + ".png");
		}
		
		public void actualizar(){
			if(duracion==duracionMax) { 
				original=afectado.getVida();
				afectado.setVida(Integer.MAX_VALUE);
				}
			
			if(duracion==0) {
				afectado.setVida(original);
				afectado.setPowerUp(new PowerUp(afectado));
			}
			else duracion--;
		}
			
}