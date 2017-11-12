package juego.ente.powerup;

import juego.ente.Personaje;

public class CuraGradual extends PowerUp{
	 protected int cura;

		public CuraGradual(Personaje p){
			super(50);
			cura=25;
		}
		
		public void actualizar(){
			if(duracion%10==0) {
				int vida=afectado.getVida();
				int vidaTotal=afectado.getVidaTotal();
				if(vida+cura>=vidaTotal){
					afectado.setVida(vidaTotal);
				}else {
					afectado.setVida(vida+cura);
				}
			}	
			if(duracion==0) 
				afectado.setPowerUp(new PowerUp());	
			else duracion--;
		}
			
}
