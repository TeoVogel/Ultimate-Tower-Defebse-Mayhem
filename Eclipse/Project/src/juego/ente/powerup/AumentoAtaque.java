package juego.ente.powerup;

import juego.ente.Personaje;

public class AumentoAtaque extends PowerUp{
	 protected int aumento;

		public AumentoAtaque(){
			super(50);
			aumento=30;
		}
		
		public void actualizar(){
			if(duracion==duracionMax) 
				afectado.setAtaque(afectado.getAtaque()+aumento);
			if(duracion==0) {
				afectado.setAtaque(afectado.getAtaque()-aumento);
				afectado.setPowerUp(new PowerUp());
			}
			else duracion--;
		}
			
}